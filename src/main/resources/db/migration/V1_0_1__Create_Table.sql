----- 修改数据库
-- alter database  um DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
-------------------------------------------------------------------------------
-------------------------------------------------------------------------------
----- 电池信息表(base)
-- BIGINT 自增列   0 - 
-- NO 电池编号
-- CHASSIS  机框
-- CHANNEL  通道
-- MODULE   模块
-- ISFORMAT 是否已经化成，默认为0
-- ISGRAD   是否已经分容，默认为0
-- ISMATCH  是否已经配对，默认为0
-- ISMASTOP 是否手动停止，默认为0
-- 主键（ ID ）
-- 索引 ( NO )
-- 索引 index_local( CHASSIS，CHANNEL，MODULE )
-- 索引 index_proc( ISFORMAT，ISGRAD，ISMATCH )

CREATE TABLE base (
	"id" bigint NOT NULL DEFAULT nextval('"base_id_seq"'::regclass),
    "no" varchar(50) ,
    "chassis" varchar(2) ,
    "channel" varchar(4) ,
    "module" varchar(2) ,
    "isformat" bit(1) default (0)::bit(1),
    "isgrad" bit(1) default (0)::bit(1),
    "ismatch" bit(1) default (0)::bit(1),
    "ismastop" bit(1) default (0)::bit(1),
    CONSTRAINT base_pkey PRIMARY KEY ("id")
);
CREATE INDEX "ba_no"
    ON base USING btree
    (no )
    TABLESPACE pg_default;

CREATE INDEX "index_local"
    ON base USING btree
    (chassis , channel , module )
    TABLESPACE pg_default;

CREATE INDEX "index_proc"
    ON base USING btree
    (isformat, isgrad, ismatch, ismastop)
    TABLESPACE pg_default;

-------------------------------------------------------------------------------
-------------------------------------------------------------------------------
-- 机框当前配置文件 表(projsf)
-- ID 自增列
-- NO 机框编号
-- SFILE json格式数据(机框编号，文件路径， 文件表格变量， 安全阀值， 开始-结束工步， 转换后的HEX字符串)
-- 主键( NO )
CREATE TABLE projsf (
	"id" smallint NOT NULL DEFAULT nextval('"projsf_id_seq"'::regclass),
    "no" varchar(2) ,
    "sfile" json,
    "pj_timesign" varchar(50),
    CONSTRAINT projsf_pkey PRIMARY KEY ("id")
);
CREATE INDEX "pr_no"
    ON projsf USING btree
    (no )
    TABLESPACE pg_default;

-------------------------------------------------------------------------------
-------------------------------------------------------------------------------
-- 机框历史文件 表(historysf)
-- ID 自增列
-- GENID 生成的ID
-- SFILE json格式数据(机框编号，文件路径， 文件表格变量， 安全阀值， 开始-结束工步， 转换后的HEX字符串)
-- TIMESIGN 时间标记(时间戳)
-- 主键( GENID )
CREATE TABLE historysf (
	"id" integer NOT NULL DEFAULT nextval('"historysf_id_seq"'::regclass),
    "genid" varchar(25),
    "sfile" json,
    "timesign" varchar(50),
    CONSTRAINT historysf_pkey PRIMARY KEY ("id")
);
CREATE UNIQUE INDEX "hi_genid"
    ON historysf USING btree
    (genid )
    TABLESPACE pg_default;

-------------------------------------------------------------------------------
-------------------------------------------------------------------------------
-- 电池配置表(basesf)
-- ID 自增列
-- baseid 电池编号
-- SFID oldsf的ID编号
-- 主键（ID）
-- 索引idx_baseid(BASEID)
-- 索引idx_sfid(SFID)
CREATE TABLE basesf(
	"id" bigint NOT NULL DEFAULT nextval('"basesf_id_seq"'::regclass),
	"baseid"   bigint   NOT NULL,
	"sfid" varchar(25) ,
	CONSTRAINT basesf_pkey PRIMARY KEY ("id")
);
CREATE INDEX "idx_baseid"
    ON basesf USING btree
    (baseid )
    TABLESPACE pg_default;
    
CREATE INDEX "idx_sfid"
    ON basesf USING btree
    (sfid )
    TABLESPACE pg_default;
-------------------------------------------------------------------------------
-------------------------------------------------------------------------------
----- 电池分容表(formation)
-- ID 序号 无符号  0 - 18446744073709551615
-- NO 电池编号
-- POSITION 位置
-- DAT_FM json格式数据(位置、电压、电流、容量、温度、内阻、PLC时间、标志，循环次数)
--	POSITION  VARCHAR(20)    GENERATED ALWAYS AS (DAT_FM -> '$.POSITION') VIRTUAL,
--	FOR_COUNT SMALLINT 		 GENERATED ALWAYS AS (DAT_FM -> '$.FOR_COUNT') VIRTUAL,
--	RETIME    INT		     GENERATED ALWAYS AS (DAT_FM -> '$.RETIME') VIRTUAL,
--	SIGNED	  VARCHAR(20)	 GENERATED ALWAYS AS (DAT_FM -> '$.SIGNED') VIRTUAL,
-- FOR_COUNT 循环次数(json的虚拟位)
-- RETIME  PLC时间(json的虚拟位)
-- SIGNED  标志(json的虚拟位)
-- INSTIME 本地时间
-- 索引 index_no( NO )
-- 索引 index_time(POSITION, SIGNED) 	INDEX 	  index_time(POSITION, SIGNED(10))
CREATE TABLE formation (
	"id" bigint NOT NULL DEFAULT nextval('"formation_id_seq"'::regclass),
	"baseid" bigint NOT NULL,
	"dat_fm" jsonb NOT NULL,
	"instime" timestamp without time zone NOT NULL,
    "p" varchar(20),
    "c" decimal(12,3),
    "step" varchar(6),
    "status" varchar(4),
	CONSTRAINT formation_pkey PRIMARY KEY ("id")
);
CREATE INDEX "fr_baseid"
    ON formation USING btree
    (baseid)
    TABLESPACE pg_default;
    
CREATE INDEX "fr_data"
    ON formation USING gin
    (dat_fm)
    TABLESPACE pg_default;

CREATE INDEX "fr_step"
    ON formation USING btree
    (baseid, step)
    TABLESPACE pg_default;
    
CREATE INDEX "fr_time"
    ON formation USING btree
    (instime desc)
    TABLESPACE pg_default;
 
-------------------------------------------------------------------------------
-------------------------------------------------------------------------------
----- 电池分选表(grading)
-- ID  自增列  0 - 4294967295
-- NO  电池编号
-- GROUP	分选组别
-- TIMESIGN 时间标记(时间戳)
-- 主键（ ID ）
-- 索引 NO( NO )

CREATE TABLE grading (
	"id" integer NOT NULL DEFAULT nextval('"grading_id_seq"'::regclass),
	"baseid" bigint NOT NULL,
	"groupclass" varchar(100) ,
	"timesign" varchar(50) ,
	"gradf" json,
	CONSTRAINT grading_pkey PRIMARY KEY ("id")
);
CREATE INDEX "gr_baseid"
    ON grading USING btree
    (baseid )
    TABLESPACE pg_default;
-------------------------------------------------------------------------------
-------------------------------------------------------------------------------	
----- 电池配对表(matches)
-- ID  自增列   0 - 4294967295
-- NO  电池编号
-- GROUPID	分选编号
-- GROUPTYPE	分选类型（几个一组）
-- 主键( ID )
-- 索引 NO ( NO )
-- 索引 GROUPID ( GROUPID )

CREATE TABLE matches (
	"id" integer NOT NULL DEFAULT nextval('"matches_id_seq"'::regclass),
	"baseid" bigint NOT NULL,
	"groupid" varchar(20) ,
	"grouptype" integer NOT NULL,
	CONSTRAINT matches_pkey PRIMARY KEY ("id")
);
CREATE INDEX "ma_baseid"
    ON matches USING btree
    (baseid )
    TABLESPACE pg_default;
CREATE INDEX "ma_groupid"
    ON matches USING btree
    (groupid )
    TABLESPACE pg_default;
    
-------------------------------------------------------------------------------
-------------------------------------------------------------------------------   
-- 每位电池（充电、放电）平均容量表，无事务表
CREATE  UNLOGGED TABLE tmp_grading( 
        "id" integer NOT NULL DEFAULT nextval('"tmp_grading_id_seq"'::regclass),
        "baseid" bigint ,
        "location" varchar(20),
        "cvalue"  decimal(12,3),
        CONSTRAINT tmp_grading_pkey PRIMARY KEY ("id")
); 
