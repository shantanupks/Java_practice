package com.example.service;

public class AccountBalanceException extends Exception{
	private double balance;

	public AccountBalanceException(double balance) {
		super();
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Not sufficient balance :"+balance;
	}

}
