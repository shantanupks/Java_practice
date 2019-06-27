package com.example.model;

import java.time.LocalDateTime;

public class Txn {
	private int id;
	private LocalDateTime localDateTime;
	private double amount;
	private double closing_balance;
	private TxnType type;
	private Account account;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getClosing_balance() {
		return closing_balance;
	}
	public void setClosing_balance(double closing_balance) {
		this.closing_balance = closing_balance;
	}
	public TxnType getType() {
		return type;
	}
	public void setType(TxnType type) {
		this.type = type;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
