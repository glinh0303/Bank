package com.likelion.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.likelion.model.Account;

public class BankManagement {
	Scanner sc = new Scanner(System.in);
	private List<Account> list;

	public BankManagement() {
		list = new ArrayList<>();
	}

	public List<Account> getList() {
		return this.list;
	}

	public void addAccount(Account acc) {
		if (acc != null) {
			list.add(acc);
		}
	}

}
