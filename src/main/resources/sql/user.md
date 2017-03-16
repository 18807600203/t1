selectUser
===

* 根据用户姓名查找

	select * from base where 1=1 
	@if(!isEmpty(id)){
	and no = #no#
	@}
	
queryNewUser
===

* 用一个sql做翻页查询，page将输出 count(1) 或者 u.*

	select #page("u.*")# from base u

updateAge
===

	update base set no = #no# where id = #id#


findBatteryInfo
===

	select * from base where no=#no#  and id=#id#

