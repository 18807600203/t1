package com.ium.um.service;

import java.util.List;

import com.ium.um.domain.battery.BatteryInfo;

public interface BatteryInfoService {
		
	//boolean insert(String chassis, String channel, String module);
	
	/**
	 * 批量添加电池信息
	 * @param biList
	 * @return
	 */
	int insertBatch(List<BatteryInfo> biList);
	
	/**
	 * 批量修改电池的编号NO
	 * @param biList
	 * @return
	 */
	int updateNoBatch(List<BatteryInfo> biList);
	
	/**
	 * 修改电池的编号NO
	 * @param id
	 * @param no
	 * @return
	 */
	boolean updateNo(Long id, String no);
	
	/**
	 * 批量更新已完成分选的电池
	 * @param idList
	 * @return
	 */
	int updateStatusBatch(List<Long> idList);
	
	/**
	 * 将对应机框的手动停止位置1
	 * @param chassisno
	 * @return
	 */
	int updateIsMastopByChassisNo(String chassisno);
	
	/**
	 * 以ID查找电池的基本信息
	 * @param id
	 * @return
	 */
	BatteryInfo findById(Long id);
	
	/**
	 * 查询没完成 化成&分容&配对  工步的电池
	 * @return
	 */
	List<BatteryInfo> findBatteryInfoInProc();
	
	/**
	 * 查询表中当前最大的ID
	 * @return
	 */
	Long getMaxId();
	
	/**
	 * 查询表中删一次没完成分容&分选操作的第一个ID
	 * <br>即本地ID表删掉后可以获得上一次的ID号
	 * @return
	 */
	Long getLastId(String chassisNo);
}


