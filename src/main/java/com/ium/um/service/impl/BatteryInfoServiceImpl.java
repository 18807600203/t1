package com.ium.um.service.impl;

import java.util.List;



import com.ium.um.domain.battery.BatteryInfo;
import com.ium.um.mapper.BatteryInfoMapper;
import com.ium.um.service.BatteryInfoService;


public class BatteryInfoServiceImpl implements BatteryInfoService{

	
	BatteryInfoMapper biMapper;	

	/**
	 * {@link com.ium.um.mapper.BatteryInfoMapper#insertBatch(List)}
	 */
	@Override
	public int insertBatch(List<BatteryInfo> biList) {
		
		//return biMapper.insertBatch(biList);
		return 0;
	}

	/**
	 * {@link com.ium.um.mapper.BatteryInfoMapper#updateNoBatch(List)}
	 */
	@Override
	public int updateNoBatch(List<BatteryInfo> biList) {
		
		//return biMapper.updateNoBatch(biList);
		return 0;
	}

	/**
	 * {@link com.ium.um.mapper.BatteryInfoMapper#updateNo(Long, String)}
	 */
	@Override
	public boolean updateNo(Long id, String no) {
		
		//return biMapper.updateNo(id, no);
		return false;
	}

	/**
	 * {@link com.ium.um.mapper.BatteryInfoMapper#updateStatusBatch(List)}
	 */
	@Override
	public int updateStatusBatch(List<Long> idList) {
		
		//return biMapper.updateStatusBatch(idList);
		return 0;
	}

	/**
	 * {@link com.ium.um.mapper.BatteryInfoMapper#updateIsMastopByChassisNo(String)}
	 */
	@Override
	public int updateIsMastopByChassisNo(String chassisno) {
		
		//return biMapper.updateIsMastopByChassisNo(chassisno);
		return 0;
	}
	
	/**
	 * {@link com.ium.um.mapper.BatteryInfoMapper#findById(Long)}
	 */
	@Override
	public BatteryInfo findById(Long id) {
		
		//return biMapper.findById(id);
		return null;
	}

	/**
	 * {@link com.ium.um.mapper.BatteryInfoMapper#findBatteryInfoInProc()}
	 */
	@Override
	public List<BatteryInfo> findBatteryInfoInProc() {
		
		//return biMapper.findBatteryInfoInProc();
		return null;
	}

	/**
	 * {@link com.ium.um.mapper.BatteryInfoMapper#getMaxId()}
	 */
	@Override
	public Long getMaxId(){
		
		//return biMapper.getMaxId();
		return 0L;
	}

	/**
	 * {@link com.ium.um.mapper.BatteryInfoMapper#getLastId()}
	 */
	@Override
	public Long getLastId(String chassisNo) {
		
		//return biMapper.getLastId(chassisNo);
		return null;
	}

}
