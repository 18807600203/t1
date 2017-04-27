package com.ium.um;

import static act.controller.Controller.Util.render;

import org.osgl.mvc.annotation.GetAction;
import org.osgl.mvc.result.Result;
import org.osgl.util.Const;

import com.ium.um.config.AppSettings;

import act.Act;
import act.inject.DefaultValue;

public class Application {
		
	 @GetAction("test")
	 public void  home(@DefaultValue("world") String who) {
		Const<Integer> chassisNum =  AppSettings.chassis.num;	
		
		int num = chassisNum.get();
	    render(who, num);
	 }
	
	
	public static void main(String[] args) throws Exception {
		
		Act.start("UMonitor");
	}	
}
