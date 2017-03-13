-- 插入化成信息表的检验
-- 如该电池的 ISFORMAT 和 ISMASTOP 都为0时才能插入
CREATE OR REPLACE FUNCTION p_insert_formation(IN baseid bigint, IN dat_fm varchar(500), IN instime varchar(25)) 
RETURNS void AS
$$
DECLARE 
	V_ISFORMAT bit(1);
    V_ISMASTOP bit(1);
    V_time timestamp without time zone;
    V_data jsonb;
BEGIN
    select isformat, ismastop INTO  V_ISFORMAT, V_ISMASTOP FROM base WHERE id = $1;
    IF( V_ISFORMAT = B'0'  AND  V_ISMASTOP = B'0' ) THEN
    	V_data := dat_fm::jsonb;
    	V_time := instime::timestamp without time zone;
		execute  ' insert into formation (baseid, dat_fm, instime) values ($1, $2, $3)' 
		using baseid, V_data, V_time;
	END IF;
END;
$$
LANGUAGE plpgsql;
-------------------------------------------------------------------------------
-------------------------------------------------------------------------------
-- 给定电池ID和工步号，查找出最大的容量C
-- 必须定义declare  v_sql
-- 最后置空 @V_C的值，防止同会话下的连接直接返回上一次的计算值
CREATE OR REPLACE FUNCTION p_find_max_c(IN baseid bigint, IN step VARCHAR(6), OUT c decimal(12,3))
AS
$$
BEGIN   
    EXECUTE 
    'select  max(c) over(partition by step) as c ,id, baseid,step from formation
			where  baseid = $1 and step = $2  limit 1;'
    INTO c
    USING baseid, step;	
END;
$$
LANGUAGE plpgsql;
-------------------------------------------------------------------------------
-------------------------------------------------------------------------------
-- 给定电池ID和指定的工步s，查找出对应工步的最大容量C
-- 循环分割STEPS中的工步(1,2,3,4,5)
-- 查找出的C不为0 则存入临时表
CREATE OR REPLACE FUNCTION p_find_avg_c(IN baseid bigint, IN steps varchar(2000), OUT avg_c decimal(12,3))
AS
$$
DECLARE 
	i integer := 0; -- 赋值
    cnt integer := 0;
    result VARCHAR(6);
    max_c decimal(12,3);
    count_c decimal(18,3) := 0; -- 容量累加值
    notnull_count integer := 0; -- 不为0的累加值
BEGIN   
   	cnt := array_length(regexp_split_to_array(steps ,','), 1); -- 数组长度  
	WHILE i < cnt LOOP
    	i := i + 1;
        result :=(regexp_split_to_array(steps ,','))[i]; -- 分割
        EXECUTE
        	' SELECT p_find_max_c($1, $2)' 
        INTO max_c
        USING baseid, result;
		IF(max_c != 0) THEN
            notnull_count := notnull_count + 1;
            count_c := count_c + max_c;
		END IF;
	END LOOP;
    BEGIN -- 平均值 
        IF(count_c = 0) THEN
        	avg_c := 0;
        ELSE
        	avg_c := count_c / notnull_count;
        END IF;
    END;	
END
$$
LANGUAGE plpgsql;
-------------------------------------------------------------------------------
-------------------------------------------------------------------------------
--	declare Vchassis varchar(5); #存放机框号的临时变量
--   declare Vchannel varchar(5); #存放通道号的临时变量 
--   declare Vmodule varchar(5);  #存放模块号的临时变量
--   declare Vid INT UNSIGNED; 
--   declare Vlocation varchar(50);
--   declare done INT DEFAULT 0;  #判断结束标记的临时变量
CREATE OR REPLACE FUNCTION p_find_single_chassis_avg_c (in para varchar(2), IN steps varchar(2000))
RETURNS void AS
$$
DECLARE 
    Vid bigint;
   	Vlocation varchar(50);
    avg_c decimal(12,3);
 	cur CURSOR  is
			select id,chassis, channel, module from base
			where chassis = para and isformat =  B'1' and isgrad = B'0' and ismatch = B'0' and ismastop = B'0'; 
BEGIN 
	FOR x in cur LOOP
    	Vid := x.id;
        Vlocation := x.chassis || '_' || x.channel || '_' || x.module;
    	EXECUTE
        	'select p_find_avg_c($1, $2)'
        INTO avg_c
        USING Vid, steps;
        EXECUTE
        	'insert into tmp_grading(baseid,location,cvalue) values ($1, $2, $3)'
        USING Vid, Vlocation, avg_c;
	END LOOP;
END;
$$
LANGUAGE plpgsql;
-------------------------------------------------------------------------------
-------------------------------------------------------------------------------
-- 给定机框s、工步s，查找出最大容量均值
-- CHASSISS 多机框
-- STEPS 多工步
CREATE OR REPLACE FUNCTION p_find_assign_chassis_avg_c (IN chassiss varchar(1000), IN steps varchar(2000))
RETURNS void AS
$$
DECLARE
	i integer := 0;
	num integer;
    result varchar(10);   
BEGIN  
    truncate table tmp_grading;
    PERFORM setval('tmp_grading_id_seq', 1, false);
    num := array_length(regexp_split_to_array(chassiss ,','), 1); -- 数组长度
    WHILE i < num LOOP   
		i := i + 1;  
        result := (regexp_split_to_array(chassiss ,','))[i]; -- 分割
        EXECUTE
        	'select p_find_single_chassis_avg_c( $1, $2)'
            USING result, steps;
	END LOOP;
END
$$
LANGUAGE plpgsql;
-------------------------------------------------------------------------------
-------------------------------------------------------------------------------
-- 给定条件，查找出电池的相关信息（暂无配对表matches）
-- item 'id'/'no'/'position'
-- vauleStr 查找值
CREATE OR REPLACE FUNCTION p_find_battery_detail(in item varchar(10), in vauleStr varchar(50), in isLimit boolean)
RETURNS TABlE(   
    id bigint,
	no varchar(50),
	chassis varchar(2),
	channel varchar(4),
	module varchar(2),
    isformat bit(1),
    isgrad bit(1),
    ismatch bit(1),
    ismastop bit(1),
	sfile json,
    sftimesign varchar(50),
	groupclass varchar(50),
    gradtimesign varchar(50),
    gradf json
) AS
$$
DECLARE
	v_sql varchar(1000);
    v1  varchar(50);
    v2  varchar(10);
    v3  varchar(10);
 	v_condition varchar(100);
	v_islimit varchar(50);
    l integer;
    len integer;
BEGIN
	if(item = 'id') then
		v1 := vauleStr;
        v_condition := CONCAT( 'id' , '=' , vauleStr); -- view
	elseif(item = 'no') then
		v1 := vauleStr;
        v_condition := CONCAT( 'no' , '=' , ''', vauleStr, '''); -- view
	elseif(item = 'position') then
		l := POSITION('_' IN  vauleStr);
		len := LENGTH(vauleStr);
		v1 := substring(vauleStr, 1, l - 1);
		v2 := substring(vauleStr, l + 1,  2);
        v3 := substring(vauleStr, 6,  len);
        v_condition := CONCAT( 'chassis' , '=''' , v1  , ''' and ' , 'channel' , '=''' , v2 , ''' and ' , 'module' , '=''', v3,''''); -- view
	END IF;
	
    if(isLimit = true) then
		v_islimit := concat(' order by id desc limit 10'); -- view
	else
		v_islimit := concat(' order by id desc');
	END IF;
    v_sql := CONCAT( 'select id, no, chassis, channel, module,
						isformat, isgrad, ismatch, ismastop,
							sfile, sftimesign, groupclass, gradtimesign 
								from vw_battery_detail where ' , v_condition , v_islimit ); -- view
    return query execute v_sql;
END
$$
LANGUAGE plpgsql;
-------------------------------------------------------------------------------
-------------------------------------------------------------------------------
-- 将对应的机框配置文件写入历史配置表， 或清空对应的机框配置表
CREATE OR REPLACE FUNCTION p_set_sfile (IN NOStr varchar(2), IN JSONStr text, IN ISSETNULL boolean, IN TIMESIGN varchar(50), IN GENID varchar(25))
RETURNS void AS
$$
DECLARE
	v_json json;
	v_id integer;
BEGIN
	v_id := NOStr::integer;
    if (ISSETNULL = true) then
		update projsf set no = null, sfile = null, pj_timesign = null  where id = v_id;
	elseif (ISSETNULL = false) then
		v_json := JSONStr::json;
		update projsf set no = NOStr, sfile = v_json, pj_timesign = localtimestamp  where id = v_id;
        insert into historysf (genid, sfile, timesign) values (GENID, v_json, TIMESIGN);
	END IF;
END
$$
LANGUAGE plpgsql;
-------------------------------------------------------------------------------
-------------------------------------------------------------------------------
--从Formation表中取出电压、电流、相对时间
--暂时是用作显示图表
--json字符串 格式化电压、电流的引号
--datatime 格式化后 不会显示.0的毫秒数
CREATE OR REPLACE FUNCTION p_find_formation_info(in baseid varchar(30))
RETURNS setof record AS
$$
DECLARE 
	v_sql varchar(1000);
	v_baseid bigint;
    rec record;
BEGIN
	v_baseid := baseid::bigint;
    v_sql := 'select dat_fm ->> ''u'' as u, dat_fm ->> ''i'' as i, instime as t from formation where baseid =  $1 order by t asc';
 	for rec in EXECUTE v_sql USING v_baseid Loop
    	return next rec;
    end loop;
	return;
END
$$
LANGUAGE plpgsql ;
-------------------------------------------------------------------------------
-------------------------------------------------------------------------------