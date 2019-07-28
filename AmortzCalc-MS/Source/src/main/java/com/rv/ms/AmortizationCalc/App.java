package com.rv.ms.AmortizationCalc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author RanvijayS
 * @version 1.0
 * @category Spring Boot Application Main Class
 * @Date 27/July/2019
 */
@SpringBootApplication
@ComponentScan({"com.rv.ms.services", "com.rv.ms.controllers"})
public class App 
{
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}

