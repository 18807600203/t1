-------------------------------------------------------------------------------
-------------------------------------------------------------------------------
-- 根据插入的json值，写入相应的电池状态
CREATE OR REPLACE FUNCTION status_trigger()
RETURNS TRIGGER AS
$$
BEGIN
	IF(NEW.dat_fm ->>'status' = 'a5') THEN
		update base set isformat = B'1' where ID = NEW.baseid;
	END IF;
	RETURN NEW;
END
$$
LANGUAGE plpgsql;

CREATE TRIGGER set_formation_status
AFTER INSERT ON formation
    FOR EACH ROW EXECUTE PROCEDURE status_trigger(); 
-------------------------------------------------------------------------------
------------------------------------------------------------------------------- 
-- 像mysql的虚拟列。      
CREATE OR REPLACE FUNCTION set_more_info()
RETURNS TRIGGER AS
$$
BEGIN
	NEW.p = NEW.dat_fm->>'position';
    NEW.c = NEW.dat_fm->>'c';
    NEW.step = NEW.dat_fm->>'step';
    NEW.status = NEW.dat_fm->>'status';
	RETURN NEW;
END
$$
LANGUAGE plpgsql;

CREATE TRIGGER set_more_info_trigger
BEFORE INSERT OR UPDATE ON formation
    FOR EACH ROW EXECUTE PROCEDURE set_more_info();    
    
    
    
    