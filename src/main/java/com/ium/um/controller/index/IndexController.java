package com.ium.um.controller.index;

import static act.controller.Controller.Util.render;

import org.osgl.mvc.annotation.GetAction;
import org.osgl.mvc.result.Result;
import org.osgl.util.Const;

import com.ium.um.config.AppSettings;

import act.inject.DefaultValue;

public class IndexController {

	@GetAction
	public void index() {
		
		Const<Integer> chassisNum =  AppSettings.chassis.num;			
		int num = chassisNum.get();
		render(num);
	}
}
