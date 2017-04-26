package com.ium.um.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ium.um.domain.battery.BatteryInfo;
import com.ium.um.mapper.BatteryInfoMapper;
import com.ium.um.service.BatteryInfoService;


@Transactional
public class BatteryInfoServiceImpl implements BatteryInfoService{

	
	BatteryInfoMapper biMapper;	

	/**
	 * {@link com.ium.um.mapper.BatteryInfoMapper#insertBatch(List)}
	 */
	@Override
	public int insertBatch(List<BatteryInfo> biList) {
		
		return biMapper.insertBatch(biList);
	}

	/**
	 * {@link com.ium.um.mapper.BatteryInfoMapper#updateNoBatch(List)}
	 */
	@Override
	public int updateNoBatch(List<BatteryInfo> biList) {
		
		return biMapper.updateNoBatch(biList);
	}

	/**
	 * {@link com.ium.um.mapper.BatteryInfoMapper#updateNo(Long, String)}
	 */
	@Override
	public boolean updateNo(Long id, String no) {
		
		return biMapper.updateNo(id, no);
	}

	/**
	 * {@link com.ium.um.mapper.BatteryInfoMapper#updateStatusBatch(List)}
	 */
	@Override
	public int updateStatusBatch(List<Long> idList) {
		
		return biMapper.updateStatusBatch(idList);
	}

	/**
	 * {@link com.ium.um.mapper.BatteryInfoMapper#updateIsMastopByChassisNo(String)}
	 */
	@Override
	public int updateIsMastopByChassisNo(String chassisno) {
		
		return biMapper.updateIsMastopByChassisNo(chassisno);
	}
	
	/**
	 * {@link com.ium.um.mapper.BatteryInfoMapper#findById(Long)}
	 */
	@Override
	public BatteryInfo findById(Long id) {
		
		return biMapper.findById(id);
	}

	/**
	 * {@link com.ium.um.mapper.BatteryInfoMapper#findBatteryInfoInProc()}
	 */
	@Override
	public List<BatteryInfo> findBatteryInfoInProc() {
		
		return biMapper.findBatteryInfoInProc();
	}

	/**
	 * {@link com.ium.um.mapper.BatteryInfoMapper#getMaxId()}
	 */
	@Override
	public Long getMaxId(){
		
		return biMapper.getMaxId();
	}

	/**
	 * {@link com.ium.um.mapper.BatteryInfoMapper#getLastId()}
	 */
	@Override
	public Long getLastId(String chassisNo) {
		
		return biMapper.getLastId(chassisNo);
	}

}
