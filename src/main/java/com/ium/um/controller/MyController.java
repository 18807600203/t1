package com.ium.um.controller;

import javax.validation.Valid;

import com.ium.um.domain.Greeting;


public class MyController {
	

	//demo

	public String showForm(Greeting greeting){
		
		return "1/form";
	}


	public String checkGreeting(@Valid Greeting greeting){
		
		//getClass(if(bindingResult.hasErrors()){
			return "1/form";
		//}
		
		return "redirect:/results";	
	}
	
	
    public String greeting() {
        
        return "greeting";
    }
}
