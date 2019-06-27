package com.example.service;

import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Account;
import com.example.model.Txn;
import com.example.model.TxnType;
import com.example.repository.AccountRepository;
import com.example.repository.TxnRepository;


public class TxrServiceImpl implements TxrService {

	private static final Logger LOGGER = Logger.getLogger("App");
	
	
	private AccountRepository accountRepository;
	
	@Autowired
	private TxnRepository txnRepository;

	public TxrServiceImpl() {
		LOGGER.info("TxrServiceImpl created");
	}

	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
		LOGGER.info("TxrServiceImpl got injection with accountRepository");
	}

	@Transactional
	@Override
	public boolean transfer(double amount, String fromAccNum, String toAccNum) {
		LOGGER.info("Txr initiated");
		Account fromAccount = accountRepository.findById(fromAccNum).get();
		Account toAccount = accountRepository.findById(toAccNum).get();

		fromAccount.setBalance(fromAccount. getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);

		accountRepository.save(fromAccount);
		boolean b = false;
		if (b)
			throw new RuntimeException("ooops");
		accountRepository.save(toAccount);
		
		
		Txn debitTxn=new Txn();
		debitTxn.setAccount(fromAccount);
		debitTxn.setAmount(amount);
		debitTxn.setClosing_balance(fromAccount.getBalance());
		debitTxn.setType(TxnType.DEBIT);
		debitTxn.setLocalDateTime(LocalDateTime.now());
		

		Txn creditTxn=new Txn();
		creditTxn.setAccount(toAccount);
		creditTxn.setAmount(amount);
		creditTxn.setClosing_balance(toAccount.getBalance());
		creditTxn.setType(TxnType.CREDIT);
		creditTxn.setLocalDateTime(LocalDateTime.now());
		
		txnRepository.save(debitTxn);
		txnRepository.save(creditTxn);

		LOGGER.info("Txr finished");

		return true;
	}

}