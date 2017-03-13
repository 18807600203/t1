-- 创建无事务的tmp_exgrad表
cREATE UNLOGGED TABLE tmp_exgrad (
	"id" bigint,
    "no" varchar(50),
    "dat_fm" jsonb,
	"instime" timestamp,
	"p" varchar(20),
	"c" decimal(12,3),
	"step" varchar(6),
	"status" varchar(4)
);
create index "ex_id" ON tmp_exgrad USING btree(id) TABLESPACE pg_default;
create index "ex_data" ON tmp_exgrad USING gin (dat_fm)TABLESPACE pg_default;
create index "ex_step"ON tmp_exgrad USING btree(id, step)TABLESPACE pg_default;
create index "ex_time"ON tmp_exgrad USING btree(instime asc)TABLESPACE pg_default;

-- 高级分选的存放表格
create UNLOGGED table tmp_exgrad_values(	
	id bigint,
	p varchar(20),
    no varchar(50),
    ocv decimal(8,4),
    avgu decimal(8,4),
    finalu decimal(8,4),
    finali int,
    maxc decimal(12,3),
    difc decimal(12,3),
    t varchar(50),
    t1 varchar(50),
	t2 varchar(50),
	t3 varchar(50),
	CONSTRAINT ex_v_pkey PRIMARY KEY ("id")
);
create INDEX "ex_v_p" ON tmp_exgrad_values USING btree(p) TABLESPACE pg_default;

-- 开路电压
-- baseid
-- 单个工步
create or replace function get_ocv(IN baseid bigint, IN step VARCHAR(6),OUT u decimal(8,4))
as
$$
begin
	execute
		'select  dat_fm ->> ''u'' as u from tmp_exgrad where  id = $1 and step = $2  limit 1'
	into u
	using baseid, step;
end
$$
LANGUAGE plpgsql immutable;

-- 平均电压
-- baseid
-- 单个工步
create or replace function get_avgU(in baseid bigint, in step varchar(6), out u decimal(8,4))
as
$$
begin
	execute
		'select avg((dat_fm ->> ''u'')::decimal(8,4)) from tmp_exgrad where id = $1 and step = $2'
	into u
	using baseid, step;
end
$$
LANGUAGE plpgsql immutable;

--最终电压
-- baseid
-- 单个工步
create or replace function get_finalU(in baseid bigint, in step varchar(6), out u decimal(8,4))
as
$$
begin
	execute
		'select dat_fm ->> ''u'' as u from tmp_exgrad where id = $1 and step = $2 order by id desc limit 1'
	-- select id,dat_fm ->> 'u' as u from formation where id = (select max(id) from formation where baseid = 605 and step = '1')
	into u
	using baseid, step;
end 
$$
LANGUAGE plpgsql immutable;

--终止电流
-- baseid
-- 单个工步
create or replace function get_finalI(IN baseid bigint, IN step VARCHAR(6), OUT i int)
as
$$
begin
	EXECUTE 
		'select dat_fm ->> ''i'' as u from tmp_exgrad where id = $1 and step = $2 order by id desc limit 1'
		-- 'select id,dat_fm ->> ''i'' as i from formation where id = (select max(id) from formation where  baseid = $1 and step = $2)'
	into i
	-- and status = 'a4'
    USING baseid, step;	
end
$$
LANGUAGE plpgsql immutable; 

-- 终止容量
-- baseid
-- 多个工步 ！！
create or replace function get_maxC(IN baseid bigint, IN steps VARCHAR(100),OUT c decimal(12,3))
as
$$
DECLARE 
	i integer := 0; -- 赋值
    cnt integer := 0;
    step VARCHAR(6);
    max_c decimal(12,3);
    count_c decimal(18,3) := 0; -- 容量累加值
begin
	cnt := array_length(regexp_split_to_array(steps ,','), 1); -- 数组长度  
	WHILE i < cnt LOOP
    	i := i + 1;
        step :=(regexp_split_to_array(steps ,','))[i]; -- 分割
		EXECUTE 
    		'select  max(c) from tmp_exgrad where  id = $1 and step = $2 '
		into max_c
		-- and status = 'a4'
    	USING baseid, step;
    	if( max_c is null) then
    		max_c := 0;
    	end if;
    	count_c := count_c + max_c;
    end LOOP;    
    select count_c into c;
end
$$
LANGUAGE plpgsql immutable;

--完成该工步的相对时间（时间有下位机提供）
-- baseid
-- 单个工步
create or replace function get_finisht(in baseid bigint, in step varchar(6), out t varchar(100))
as
$$
begin
	execute
		'select max(dat_fm ->> ''t'') from tmp_exgrad where id = $1 and step = $2'
	into t
	using baseid, step;
end
$$
LANGUAGE plpgsql immutable;

--特征点时间
-- baseid
-- 单个工步
-- 特征电压值
create or replace function get_upoint(IN baseid bigint, IN step VARCHAR(6), in u varchar(10), out t varchar(100))
as
$$
declare
	du decimal(8,4);
begin
	du := u::decimal(8,4);
	EXECUTE 
    	'select dat_fm ->> ''t'' as t from tmp_exgrad where id = $1 and step = $2 and 
			(dat_fm ->> ''u'')::decimal(8,4) <= $3 order by instime asc limit 1'
    into t
	-- and status = 'a4'
    USING baseid, step, du;	
end
$$
LANGUAGE plpgsql immutable;

-- 取3个工步之间最小容量（可以更多）
-- ID
-- 多个工步
create or replace function get_minC(in baseid bigint, in steps varchar(100), out c decimal(12,3))
as
$$
declare
	i integer := 0; -- 赋值
    cnt integer := 0;
    step VARCHAR(6);
    min_c decimal(12,3);
    record_c decimal(12,3) := 0;
begin
	cnt := array_length(regexp_split_to_array(steps ,','), 1); -- 数组长度  
	WHILE i < cnt LOOP
    	i := i + 1;
        step :=(regexp_split_to_array(steps ,','))[i]; -- 分割
        execute
    		'select  min(c) from tmp_exgrad where  id = $1 and step = $2 '
		into min_c
		-- and status = 'a4'
    	USING baseid, step;
    	if(i = 1) then
    		record_c := min_c;
    	elseif(min_c < record_c) then
    		record_c := min_c;
 		end if;
 	end LOOP;
    select record_c into c;
end
$$
LANGUAGE plpgsql immutable;

-- 取2个工步之间的容量差（可以更多）
-- ID
-- 多个工步
create or replace function get_difC(in baseid bigint, in steps varchar(100), out c decimal(12,3))
as
$$
declare
	i integer := 0; -- 赋值
    cnt integer := 0;
    step VARCHAR(6);
    max_c decimal(12,3);
    record_c decimal(12,3) := 0;
begin
	cnt := array_length(regexp_split_to_array(steps ,','), 1); -- 数组长度  
	WHILE i < cnt LOOP
    	i := i + 1;
        step :=(regexp_split_to_array(steps ,','))[i]; -- 分割
        execute
    		 'select  max(c) from tmp_exgrad where  id = $1 and step = $2 '
    		-- 'select  max(c) from '|| $3 ||' where  baseid = $1 and step = $2'
		into max_c
		-- and status = 'a4'
    	USING baseid, step;
    	if(i = 1) then
    		record_c := max_c;
    	else
    		record_c := record_c - max_c;
 		end if;
 	end LOOP;
    select abs(record_c) into c; -- 绝对值
end
$$
LANGUAGE plpgsql immutable;

-- 将备选的机框号取出并关联formation表， 写进tmp_exgrad表
create or replace function get_cursor(in para varchar(2)) 
returns void as 
$$		
begin
	execute 'insert into tmp_exgrad
   		select a.id,a.no, b.dat_fm, b.instime,  a.p, b.c, b.step, b.status from 
			(select id, no, (chassis||''_''||channel||''_''||module) as p  from base where chassis = $1 and 
		isformat =  1::bit and isgrad = 0::bit and ismatch = 0::bit and ismastop = 0::bit ) a 
		left join formation b on a.id = b.baseid'
	using para;
end
$$
LANGUAGE plpgsql;

-- 核心算法入口
-- 机框s
-- 电压分选工步
-- 终止容量的分选工步s
-- 最小容量（3）或容量差（2）的分选工步
-- 电流分选工步
-- 特征放电电压（3）
create or replace function p_ex_grad(
	in chassises varchar(100), 
	in ustep varchar(100), 
	in maxcsteps text,
	in minordifcsteps text,
	in istep varchar(100), 
	in ufeatures text
)
RETURNS setof tmp_exgrad_values 
AS
$$
DECLARE 
    i integer := 0; -- 赋值
    cnt integer := 0;
    chassis VARCHAR(6);
    v_count integer := 0; --判断tmp_exgrad是否无数据
    -- rec exgrad_values%rowtype;
BEGIN 
	truncate table tmp_exgrad;
	truncate table tmp_exgrad_values;
	cnt := array_length(regexp_split_to_array(chassises ,','), 1); -- 数组长度  
	WHILE i < cnt LOOP
    	i := i + 1;
        chassis :=(regexp_split_to_array(chassises ,','))[i]; -- 分割
		PERFORM get_cursor(chassis);-- 截取机框下的所有信息到tmp_exgrad表中
	end loop;	
	execute
	 	'select get_exgrad_values( $1, $2, $3, $4, $5)'
	using ustep, maxcsteps, minordifcsteps, istep, ufeatures; 
	return query select id, p, no, ocv, avgu, finalu, finali, maxc, difc, t, t1, t2, t3 from tmp_exgrad_values;
END
$$
LANGUAGE plpgsql;

-- 核心算法
-- 电压分选工步
-- 终止容量的分选工步s
-- 最小容量（3）或容量差（2）的分选工步
-- 电流分选工步
-- 特征放电电压（3）
create or replace function get_exgrad_values(
	in ustep varchar(100), 
	in maxcsteps text,
	in minordifcsteps text,
	in istep varchar(100), 
	in ufeatures text
)
returns void as 
$$
declare
	ocv decimal(8,4);
    avgu decimal(8,4);
    finalu decimal(8,4);
    finali int;
    maxc decimal(12,3);
    difc decimal(12,3);
    t varchar(50) ;
    t1 varchar(50) ;
	t2 varchar(50) ;
	t3 varchar(50);
		
	b1 boolean := true;
	b2 boolean := true;
	b3 boolean := true;
	b4 boolean := true;
	b5 boolean := true;
	
	v_count int := 0;
	
	maxcstep text[] := string_to_array(maxcsteps, ','); --容量分容条件转换为数组
	minordifcstep text[] := string_to_array(minordifcsteps, ','); -- 最小容量或容量差 转换条件
	ufeature text[] := string_to_array(ufeatures, ','); --特征电压
	
	cur cursor is --打开游标
		select distinct on (id) id, p, no from tmp_exgrad ;
		
begin
	if( ustep = '0') then -- 电压分选条件为0
		b1 := false; --不参与循环，直接赋值
	end if;
	
	if( istep = '0') then --电流分选条件为0
		b2 := false;--不参与循环，直接赋值
	end if;
	
	if( ufeature[1] = '0') then --特征电压分选条件为0		
		b3 := false;--不参与循环，直接赋值
	end if;
	
	if( ufeature[2] = '0') then --特征电压分选条件为0		
		b4 := false;--不参与循环，直接赋值
	end if;
	
	if( ufeature[3] = '0') then --特征电压分选条件为0		
		b5 := false;--不参与循环，直接赋值
	end if;
	
	for x in cur loop
		if(b1) then 	
			select get_ocv(x.id, ustep) into ocv; -- 开路电压
			select get_avgU(x.id, ustep ) into avgu;-- 均压		
			select get_finalU(x.id, ustep) into finalu; -- 终止电压
		else
			ocv := 0;
			avgu := 0;
			finalu := 0;
		end if;
		
		if(b2) then		
			select get_finalI(x.id, istep) into finali;-- 终止电流
		else
			finali := 0;
		end if;	
		
		if(b3)then
			select get_upoint(x.id, maxcstep[1], ufeature[1]) into t1;-- 特征电压时间点1
		else
			t1 := '0';
		end if;
		
		if(b4)then
			select get_upoint(x.id, maxcstep[1], ufeature[2]) into t2;-- 特征电压时间点2
		else
			t2 := '0';
		end if;
		
		if(b5)then
			select get_upoint(x.id, maxcstep[1], ufeature[3]) into t3;-- 特征电压时间点3
		else
			t3 := '0';
		end if;
		
		select get_maxc(x.id, maxcsteps) into maxc; -- 终止容量
		select get_finisht(x.id, maxcstep[1] ) into t; --终止容量的完成时间
				
		v_count := array_length(regexp_split_to_array(minordifcsteps ,','), 1);
		if(v_count = 2) then
			select get_difC(x.id, minordifcsteps) into difc;--2个工步间的差的绝对值
		else
			select get_minC(x.id, minordifcsteps) into difc;--工步间的最小容量
		end if;
		execute
			'insert into tmp_exgrad_values values( $1, $2, $3, $4, $5, $6, $7, $8, $9, $10, $11, $12, $13)'
		using x.id, x.p, x.no, ocv, avgu,finalu, finali,maxc, difc, t, t1, t2, t3;
		
  	end loop;
end
$$
LANGUAGE plpgsql;

-- 计算java的时间戳
-- 转换为bigint 再除以1000 的值再用数据库内置函数转换
create or replace function get_timestamp(in value varchar(50), out t timestamp)
as
$$
declare v bigint;
begin
	v := value::bigint / 1000;
	execute
		' SELECT TIMESTAMP WITH TIME ZONE ''epoch'' + $1 * INTERVAL ''1 second'' '
	into t using v;
end 
$$
LANGUAGE plpgsql immutable;