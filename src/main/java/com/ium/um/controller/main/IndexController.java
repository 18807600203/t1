package com.ium.um.controller.main;


import com.ium.um.config.AppConfig;

public class IndexController {

	
    private AppConfig appConfig;
	
	public String index(){
		
		String numStr = appConfig.getChassisNum();
		Integer num = Integer.valueOf(numStr);
		
		//model.addAttribute("chassis", num);
		return "main/index";
	}
	
}
