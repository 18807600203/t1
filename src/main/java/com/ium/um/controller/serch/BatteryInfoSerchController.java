package com.ium.um.controller.serch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ium.um.domain.BatteryInfo;
import com.ium.um.mapper.BatteryInfoMapper;

@Controller
@RequestMapping("/serch")
public class BatteryInfoSerchController {

	@Autowired
    private BatteryInfoMapper biMapper;
	
	
	@GetMapping("/getAll")
	@ResponseBody
    public List<BatteryInfo> getAll() {
		
		List<BatteryInfo> bis = biMapper.getAll();
		
        if(bis.isEmpty()){
        	
           return null;
        }
        return bis;
    }
	
	@GetMapping("/greeting") //value="id", required=false, defaultValue="2"
    public String greeting() {
        
        return "greeting";
    }
	
	@RequestMapping(value = "/greeting/{no}", method = RequestMethod.GET)
	@ResponseBody
    public BatteryInfo findById(@PathVariable String no) {
        
        BatteryInfo bis = biMapper.findByNo(no);
        if(bis == null){
        	
           return null;
        }
        return bis;
    }
	
	@RequestMapping(value = "/greeting/{item}/{value}/{islimit}")
	@ResponseBody
	public List<Object> findDetail(@PathVariable String item,  @PathVariable String value, @PathVariable boolean islimit){
		
		List<Object> bis = biMapper.findBatteryDetail(item, value, islimit);
		return bis;
	}
}
