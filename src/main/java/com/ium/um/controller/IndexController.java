package com.ium.um.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ium.um.domain.AppConfig;

@Controller
@RequestMapping("/index")
public class IndexController {

	@Autowired
    private AppConfig appConfig;
	
	@GetMapping
	public String index(){
		
		return "/main/index";
	}
	
	@GetMapping("/left")
	@ResponseBody
	public String left(){
		
		return appConfig.getChassisnum();
	}
}