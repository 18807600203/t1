package com.ium.um.controller.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ium.um.domain.BatteryDetail;
import com.ium.um.domain.BatteryInfo;
import com.ium.um.service.impl.BatteryDetailServiceImpl;

@Controller
@RequestMapping("/serch")
public class BatteryDetailSerchController {

	@Autowired
	BatteryDetailServiceImpl bdServiceImpl;
	
	@RequestMapping(value = "/{item}/{value}/{isLimit}", method = RequestMethod.GET)
	@ResponseBody
    public List<BatteryDetail> find(@PathVariable String item, @PathVariable String value, @PathVariable boolean isLimit) {
        
		List<BatteryDetail> bds = bdServiceImpl.find(item, value, isLimit);
        if(bds.isEmpty()){
        	
           return null;
        }
        return bds;
    }
}
