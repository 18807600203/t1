package com.ium.um.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ium.um.domain.BatteryInfo;
import com.ium.um.mapper.BatteryInfoMapper;

@RestController
public class MyController {
	
	
	@Autowired
    private BatteryInfoMapper biMapper;
	
	@GetMapping("/")
	String home(){
		
		return "hello";
	}
	
	
	
	
	@GetMapping("/getUserInfo")
	@ResponseBody
    public BatteryInfo getUserInfo() {
		
		BatteryInfo user = biMapper.findById(1L);
        if(user==null){
        	
           return null;
        }
        return user;
    }
}
