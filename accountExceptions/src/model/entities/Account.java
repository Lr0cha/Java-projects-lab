package model.entities;

import model.Exceptions.DomainException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
		
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	
	public void deposit(double value) {
		balance += value;
	}
	
	public void withdraw(double value) throws DomainException {
		if(value > balance) {
			throw new DomainException("Saque é maior que o valor total da conta!");
		}
		else if (value > withdrawLimit){
			throw new DomainException("Saque solicitado maior que o limite de valor! ");
		}
		balance -= value;
	}
	
}
