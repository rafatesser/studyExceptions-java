package model.entities;

import java.util.Random;

import model.exception.DomainException;

public class Account {
	
	Random r = new Random();
	private final Integer number = r.nextInt(99999);
	private final Integer dac = r.nextInt(9);
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
		
	}
	
	public Account(String holder, Double balance, Double withdrawLimit) {
 		setHolder(holder);
		setBalance(balance);
		setWithdrawLimit(withdrawLimit);	
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		if(holder == null || holder.isBlank()) {
			throw new IllegalArgumentException("Holder is invalid!");
		}
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		if(balance < 0 || balance.isNaN() || balance.equals(null)) {
			throw new NullPointerException("Balance is invalid!");
		}
		this.balance = balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		if(withdrawLimit == null) {
			throw new NullPointerException("Withdraw Limit is invalid!");
		}
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}
	
	public void deposit(Double deposit) {
		if(deposit <= 0) {
			throw new IllegalArgumentException("Deposit zeroes is invalid operation!");
		}
		setBalance(deposit);
	}
	
	public void withdraw(Double withdraw) throws DomainException{
		if(withdraw > getWithdrawLimit()) {
			throw new DomainException("Transaction is invalid! Withdraw greater Withdraw Limit");
		}
		
		if(withdraw > getBalance() || getBalance() == 0) {
			throw new DomainException("Transaction is invalid! Without Balance");
		}
		
		if(withdraw == 0) {
			throw new IllegalArgumentException("Withdraw zeroes is invalid operation!");		
		}
		
		Double operation = getBalance() - withdraw;
		setBalance(operation);
		
	}

	public Integer getDac() {
		return dac;
	}
	
	
	
}
