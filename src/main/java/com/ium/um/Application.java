package com.ium.um;

import static act.controller.Controller.Util.render;

import org.osgl.mvc.annotation.GetAction;
import org.osgl.mvc.result.Result;
import org.osgl.util.Const;
import act.Act;
import act.app.conf.AutoConfig;
import act.inject.DefaultValue;

public class Application {
			
	 @GetAction("test")
	 public void  home(@DefaultValue("world") String who) {
		
	    render(who);
	 }
	
	public static void main(String[] args) throws Exception {
		
		Act.start("UMonitor");
		
	}	
}
