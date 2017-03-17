package com.ium.um.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ium.um.domain.BatteryInfo;
import com.ium.um.domain.Greeting;
import com.ium.um.mapper.BatteryInfoMapper;

@Controller
public class MyController extends WebMvcConfigurerAdapter{
	
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		registry.addViewController("/results").setViewName("results");
	}


	@Autowired
    private BatteryInfoMapper biMapper;
	
	
	@PostMapping("/insert")
	public boolean insertInfo(@ModelAttribute("batteryinfo")BatteryInfo bi ){
		
		boolean b = biMapper.insert(bi.getChassis(), bi.getChannel(), bi.getModule());
		return b;
	}
	
	
	@GetMapping("/getAll")
	@ResponseBody
    public BatteryInfo getAll() {
		
		BatteryInfo user = biMapper.findById(1L);
        if(user==null){
        	
           return null;
        }
        return user;
    }
	

	//demo
	@GetMapping("/")
	public String showForm(Greeting greeting){
		
		return "form";
	}


	@GetMapping("/index")
	public String showIndex(Model model){
		Greeting greeting = new Greeting();
		greeting.setName("test");
		greeting.setAge(29);
		model.addAttribute("myData", greeting);
		return "index";
	}
	
	
	@PostMapping("/")
	public String checkGreeting(@Valid Greeting greeting, BindingResult bindingResult){
		
		if(bindingResult.hasErrors()){
			return "form";
		}
		
		return "redirect:/results";
		
		
	}
}
