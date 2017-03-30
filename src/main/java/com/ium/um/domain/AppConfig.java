package com.ium.um.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:appconf.properties")
@ConfigurationProperties(prefix = "my" )
@Component
public class AppConfig {

	private String chassisnum;

	public String getChassisnum() {
		return chassisnum;
	}

	public void setChassisnum(String chassisnum) {
		this.chassisnum = chassisnum;
	}


}
