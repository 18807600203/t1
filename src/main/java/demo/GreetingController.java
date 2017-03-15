package demo;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import io.ebean.EbeanServer;

@Controller
public class GreetingController extends WebMvcConfigurerAdapter{

	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addViewController("/results").setViewName("results");
	}

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
