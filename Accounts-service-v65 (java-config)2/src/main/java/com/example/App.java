package com.example;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.service.AccountBalanceException;
import com.example.service.TxrService;

public class App {

	private static final Logger LOGGER = Logger.getLogger("App");

	public static void main(String[] args) {

		// -------------------------------------
		// init / boot
		// -------------------------------------

		ConfigurableApplicationContext context = null;
		context = new ClassPathXmlApplicationContext("account-service.xml");
		

		LOGGER.info("app init/booted..");
		System.out.println();
		// -------------------------------------
		// use
		// -------------------------------------
		LOGGER.info("app in use");
		TxrService txrService;
		try {
			txrService = context.getBean("txrService", TxrService.class);
			txrService.transfer(100.00, "1", "2");
			
			System.out.println();

			System.out.println();
			// -------------------------------------
			// destroy
			// -------------------------------------
			LOGGER.info("app destroyed");
			//
			// -------------------------------------
		} catch (BeansException e1) {
			e1.printStackTrace();
		} catch (AccountBalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
			
	}

}