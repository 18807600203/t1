package com.ium.um.controller.index;

import static act.controller.Controller.Util.render;

import org.osgl.mvc.annotation.GetAction;
import org.osgl.mvc.result.Result;
import org.osgl.util.Const;
import act.app.conf.AutoConfig;
import act.inject.DefaultValue;

@AutoConfig
public class IndexController {

	private static int CHASSIS_NUM;
	
	@GetAction
	public void index() {
		
		int num = CHASSIS_NUM;//机框数量
		
		render(num);
	}
}
