--	语法:alter table 表名 add constraint FK_ID foreign key(你的外键字段名) REFERENCES 主键表名(对应的表的主键字段名);

-- formation的baseid字段 是 base-ID 字段的外键
alter table formation add constraint FK_NO_F foreign key(baseid) references base(id) on update RESTRICT on delete RESTRICT;


-- grading的baseid字段 是 base-ID 字段的外键
alter table grading add constraint FK_NO_G foreign key(baseid) references base(id) on update RESTRICT on delete RESTRICT;


-- matches的baseid字段 是 base-ID 字段的外键
alter table matches add constraint FK_NO_M foreign key(baseid) references base(id) on update RESTRICT on delete RESTRICT;


-- basesf的baseid字段  是 base-ID 字段的外键
alter table basesf add constraint FK_NO_B foreign key(baseid) references base(id) on update RESTRICT on delete RESTRICT;

-- basesf的SFID字段  是historysf(GENID) 字段的外键
alter table basesf add constraint FK_ID foreign key(sfid) references historysf(genid) on update RESTRICT on delete set null;
