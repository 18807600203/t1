package batteryinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class MyController {

	@Autowired
	BatteryInfoService service;
	
    @RequestMapping("/index.html")
    public ModelAndView home() {
        ModelAndView view = new ModelAndView("/index.btl");
        view.addObject("total", service.total());
        return view;
    }
    
    @RequestMapping("/addUser.html")
    public ModelAndView addUser() {
    	BatteryInfo bi = new BatteryInfo();
    	bi.setChassis("1");
    	bi.setChannel("01");
    	bi.setModule("1");
    	service.save(bi);
    	
        ModelAndView view = new ModelAndView("/index.btl");
        view.addObject("total", service.total());
        return view;
    }
}
