package com.likelion.model;

import java.math.BigDecimal;

public abstract class Account {
	private int id;
	private String accountNumber;
	private String name;
	private TypeOfAccount typeOfAccount;
	private BigDecimal balance;
	private BigDecimal deposit;

	public Account() {
		this.balance = BigDecimal.ZERO;
	}

	public int getId() {
		return id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getName() {
		return name;
	}

	public TypeOfAccount getTypeOfAccount() {
		return typeOfAccount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public BigDecimal getDeposit() {
		return deposit;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTypeOfAccount(TypeOfAccount typeOfAccount) {
		this.typeOfAccount = typeOfAccount;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
	}

	@Override
	public String toString() {
		return "Account{" + "id=" + id + ", accountNumber='" + accountNumber + '\'' + ", name='" + name + '\''
				+ ", typeOfAccount=" + typeOfAccount + ", balance=" + balance + ", deposit=" + deposit + '}';
	}
}
