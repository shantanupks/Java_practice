package com.example.model;

import java.time.LocalDateTime;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "accounts_transaction")
public class Txn {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(name = "time")
	private LocalDateTime localDateTime;
	private double amount;
	private double closing_balance;
	
	@Enumerated(EnumType.STRING)
	private TxnType type;
	
	@ManyToOne
	@JoinColumn(name = "account_num")
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
