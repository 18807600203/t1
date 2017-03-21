package com.ium.um;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



//@SpringBootApplication
//implements CommandLineRunner
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
		System.out.println( 0.05 + 0.02);
		System.out.println( (float)(0.05 + 0.001));
	}

}
