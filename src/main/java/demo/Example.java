package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.ebean.Ebean;
import io.ebean.EbeanServer;

@SpringBootApplication
public class Example {
	
	
	public static void main(String[] args){
		
		SpringApplication.run(Example.class, args);
		
	}

}
