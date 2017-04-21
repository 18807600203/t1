package com.ium.um.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:appconf.properties")
@ConfigurationProperties(prefix = "my" )
@Component
public class AppConfig {

	private String chassisNum;
	private String url;
	private String userName;
	private String passWord;
	
	public String getChassisNum() {
		return chassisNum;
	}
	
	public void setChassisNum(String chassisNum) {
		this.chassisNum = chassisNum;
	}
	
	@Lazy
	@Bean(name = "url")
	public String getUrl() {
		return url;
	}
		
	public void setUrl(String url) {
		this.url = url;
	}
	@Lazy
	@Bean(name = "userName")
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Lazy
	@Bean(name = "passWord")
	public String getPassWord() {
		return passWord;
	}
	
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	

}
