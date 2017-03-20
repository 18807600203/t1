package com.ium.um.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ium.um.domain.BatteryInfo;
import com.ium.um.domain.Greeting;
import com.ium.um.mapper.BatteryInfoMapper;

@Controller
public class MyController extends WebMvcConfigurerAdapter{
	
	@Autowired
    private BatteryInfoMapper biMapper;
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		registry.addViewController("/results").setViewName("results");
	}

	
	@PostMapping("/insert")
	public boolean insertInfo(@ModelAttribute("batteryinfo")BatteryInfo bi ){
		
		boolean b = biMapper.insert(bi.getChassis(), bi.getChannel(), bi.getModule());
		return b;
	}
	
	@RequestMapping("/getAll")
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

	@PostMapping("/")
	public String checkGreeting(@Valid Greeting greeting, BindingResult bindingResult){
		
		if(bindingResult.hasErrors()){
			return "form";
		}
		
		return "redirect:/results";	
	}
	
	@RequestMapping("/greeting")
    public String greeting(@RequestParam(value="id", required=false, defaultValue="2") String id, Model model) {
        
        BatteryInfo bis = biMapper.findById( Long.valueOf(id));
		
        if(bis == null){
        	
           return null;
        }
        model.addAttribute("id", bis);
        return "greeting";
    }
}
