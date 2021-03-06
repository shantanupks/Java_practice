package com.example;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.config.AccountServiceConfiguration;
import com.example.repository.AccountRepository;
import com.example.service.AccountBalanceException;
import com.example.service.TxrService;
import com.example.service.TxrServiceImpl;

public class App {

	private static final Logger LOGGER = Logger.getLogger("App");

	public static void main(String[] args) {

		// -------------------------------------
		// init / boot
		// -------------------------------------

		
		ConfigurableApplicationContext context = null;
		context =new AnnotationConfigApplicationContext(AccountServiceConfiguration.class);
		
		LOGGER.info("app init/booted..");
		System.out.println();
		// -------------------------------------
		// use
		// -------------------------------------
		LOGGER.info("app in use");
		
		TxrService txrService=context.getBean("txrService",TxrService.class);
		txrService.transfer(100, "1", "2");
		

		// -------------------------------------
		// destroy
		// -------------------------------------
		LOGGER.info("app destroyed");
		context.close();
		
		
		
			
	}

}