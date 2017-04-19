package com.ium.um.controller;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.ium.um.domain.Greeting;

@Controller
public class MyController extends WebMvcConfigurerAdapter{
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		registry.addViewController("/results").setViewName("results");
	}

	//demo
	@GetMapping("/")
	public String showForm(Greeting greeting){
		
		return "/1/form";
	}

	@PostMapping("/")
	public String checkGreeting(@Valid Greeting greeting, BindingResult bindingResult){
		
		if(bindingResult.hasErrors()){
			return "/1/form";
		}
		
		return "redirect:/results";	
	}
	
	@GetMapping("/greeting") //value="id", required=false, defaultValue="2"
    public String greeting() {
        
        return "greeting";
    }
}
