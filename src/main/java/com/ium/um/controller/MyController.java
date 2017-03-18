package com.ium.um.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public List<BatteryInfo> getAll() {
		
		List<BatteryInfo> bis = biMapper.getAll();
		
        if(bis.isEmpty()){
        	
           return null;
        }
        return bis;
    }
	
	@GetMapping("/insert")
	public String getAll(Model model){
		
		List<BatteryInfo> bis = biMapper.getAll();
		
        if(bis.isEmpty()){
        	
           return null;
        }
		model.addAttribute("batteryinfo", bis);
		return "insert";		
	}
	

	//demo
	@GetMapping("/")
	public String showForm(Greeting greeting){
		
		return "form";
	}


	@GetMapping("/index")
	public String showIndex(Model model){
		Greeting greeting = new Greeting();
		greeting.setName("test_hotLoad");
		greeting.setAge(57);
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
