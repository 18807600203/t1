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

import com.ium.um.domain.BatteryDetail;
import com.ium.um.domain.BatteryInfo;
import com.ium.um.mapper.BatteryInfoMapper;
import com.ium.um.service.impl.BatteryInfoServiceImpl;

@Controller
@RequestMapping("/serch")
public class BatteryInfoSerchController {

	@Autowired
    private BatteryInfoServiceImpl biServiceImpl;
		
	@GetMapping("/getAll")
	@ResponseBody
    public List<BatteryInfo> getAll() {
		
		List<BatteryInfo> bis = biServiceImpl.getAll();
		
        if(bis.isEmpty()){
        	
           return null;
        }
        return bis;
    }
	
	@RequestMapping(value = "/greeting/{no}", method = RequestMethod.GET)
	@ResponseBody
    public BatteryInfo findById(@PathVariable String no) {
        
        BatteryInfo bis = biServiceImpl.findByNo(no);
        if(bis == null){
        	
           return null;
        }
        return bis;
    }
	
}
