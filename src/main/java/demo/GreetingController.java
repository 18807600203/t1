package demo;


import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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
	public String showIndex(Greeting greeting){
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
