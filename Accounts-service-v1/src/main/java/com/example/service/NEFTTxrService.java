package com.example.service;

import org.apache.log4j.Logger;

import com.example.model.Account;
import com.example.repository.JdbcAccountRepository;


/*
 * 
 *  design & performance issues
 *  -----------------------------
 *  
 *  --> tight-coupling b/w dependent & dependency
 *  	==> can't extend module with new features
 *  --> too many duplicate dependency instances created & destroyed
 *  	==> slow,memory/resource use high
 *  --> unit-testing not possible
 *  	==> dev/bug fix slow
 *  
 *   
 *  why these issues ?
 *  
 *  	==> dependent itself creating it's own dependency
 *  
 *  soln:
 *  
 *  	==> don't create , lookup from factory
 *  
 *  limitation factory-lookup:
 *   
 *      ==> factory location tight-coupling 	
 *      
 *  best-soln:
 *  
 *  	==> don't create/lookup , get / inject by 'third-party' ( IOC )
 *  
 *  	IOC ==> Inversion of Control
 *  
 *  	how to implement IOC ?
 *  
 *  	way-1 : dependency injection ( DI )
 *  
 *  			ways:
 *  
 *  			-> constructor DI
 *  			-> setter DI
 *  	 
 *
 *      
 *  		 
 *		 
 */		 

public class NEFTTxrService {

	private static final Logger LOGGER = Logger.getLogger("App");

	public NEFTTxrService() {
		LOGGER.info("NEFTTxrService created");
	}

	public boolean transfer(double amount, String fromAccNum, String toAccNum) {
		LOGGER.info("Txr initiated");

		JdbcAccountRepository accountRepository = new JdbcAccountRepository();

		Account fromAccount = accountRepository.load(fromAccNum);
		Account toAccount = accountRepository.load(toAccNum);

		// debit & credit

		accountRepository.update(fromAccount);
		accountRepository.update(toAccount);

		LOGGER.info("Txr finished");
		return true;

	}

}