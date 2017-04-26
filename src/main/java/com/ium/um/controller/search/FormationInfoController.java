package com.ium.um.controller.search;


import java.util.Date;


import com.ium.um.domain.formation.FormationData;
import com.ium.um.service.impl.FormationInfoServiceImpl;

public class FormationInfoController {

	
	FormationInfoServiceImpl fiImpl;
	
	
	public FormationData getInfo( String chassis, String channel,  String module){
		
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
