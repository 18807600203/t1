package com.ium.um.controller.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ium.um.config.AppConfig;

@Controller
@RequestMapping("index")
public class IndexController {

	@Autowired
    private AppConfig appConfig;
	
	@GetMapping
	public String index(Model model){
		
		String numStr = appConfig.getChassisNum();
		Integer num = Integer.valueOf(numStr);
		
		model.addAttribute("chassis", num);
		return "main/index";
	}
	
}
