CREATE or REPLACE VIEW vw_battery_detail AS
	select a.id, a.no, a.chassis, a.channel, a.module, a.isformat, a.isgrad, a.ismatch, a.ismastop,f.sfile, f.timesign as sftimesign,
						c.groupclass, c.timesign as gradtimesign, c.gradf from ((base a left join basesf b on a.id = b.baseid ) 
       						left join historysf f on f.genid = b.sfid ) left join grading c on a.id = c.baseid ;