package com.ium.um.config;

import org.osgl.util.Const;
import org.osgl.$;
import act.app.conf.AutoConfig;

@AutoConfig
public class AppSettings {
	
	
	public static class chassis {
		
        public static Const<Integer> num = $.constant();
    }
}
