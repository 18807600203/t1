package com.ium.um.controller.mainmenu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("step")
public class StepSettingController {

	@GetMapping
	public String index(Model model){
		
		return "mainmenu/stepsetting";
	}
}
