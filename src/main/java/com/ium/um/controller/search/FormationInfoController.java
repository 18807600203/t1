package com.ium.um.controller.search;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ium.um.domain.FormationData;
import com.ium.um.service.impl.FormationInfoServiceImpl;

@Controller
@RequestMapping("/show")
public class FormationInfoController {

	@Autowired
	FormationInfoServiceImpl fiImpl;
	
	@RequestMapping(value = "/{chassis}/{channel}/{module}", method = RequestMethod.GET)
	@ResponseBody
	public FormationData getInfo(@PathVariable String chassis, @PathVariable String channel, @PathVariable String module){
		
		FormationData fd = new FormationData();
		fd.setPosition(channel + "_" + channel + "_" +module);
		fd.setC("0.5");
		fd.setStep("1");
		fd.setStatus("a0");
		fd.setU("4200");
		fd.setI("500");
		
		fiImpl.add(7040L, fd, new Date().toString());
		return fd;
	}
}
