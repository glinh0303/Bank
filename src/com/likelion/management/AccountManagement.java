package com.likelion.management;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.likelion.model.Account;
import com.likelion.model.CurrentAccount;
import com.likelion.model.SavingAccount;
import com.likelion.model.TypeOfAccount;

public class AccountManagement {
	Scanner sc = new Scanner(System.in);
	private Account account;
	private List<Account> savingaccounts;
	private List<Account> currentAccounts;
	private int id;

	public AccountManagement() {
		savingaccounts = new ArrayList<>();
		currentAccounts = new ArrayList<>();
		id = 1;
	}

	public List<Account> getSavingList() {
		return this.savingaccounts;
	}

	public List<Account> getCurrentList() {
		return this.currentAccounts;
	}

	public Account createAccount() {

		try {
			System.out.println("Choose type of Account: ");
			showTypeOfAcc();
			int choose = sc.nextInt();
			account = account(choose);

			account.setId(id++);

			String accNumber = String.valueOf(account.getId());

			account.setAccountNumber(accNumber);
			System.out.println("Enter name: ");
			String name = sc.nextLine();
			name += sc.nextLine();

			account.setName(name);
			deposit();

			addAccount();
			return account;

		} catch (NullPointerException ex) {
			System.err.println(ex.getMessage());
		}
		return null;
	}

	public void addAccount() {
		TypeOfAccount type = account.getTypeOfAccount();
		if (type.equals(TypeOfAccount.CurrentAccount)) {
			currentAccounts.add(account);
		} else {
			savingaccounts.add(account);
		}
	}

	public void balance(BigDecimal amount, String service) {

		BigDecimal balance = account.getBalance();
		if (service.equalsIgnoreCase("add")) {
			if (amount.compareTo(BigDecimal.ZERO) > 0) {
				account.setBalance(balance.add(amount));
			}
		} else if (service.equalsIgnoreCase("substract")) {
			account.setBalance(balance.subtract(amount));
		}
	}

	public BigDecimal deposit() {
		try {
			System.out.println("Enter deposit: ");
			BigDecimal deposit = sc.nextBigDecimal();
			if (deposit.compareTo(BigDecimal.ZERO) <= 0) {
				System.err.println("Deposit should be larger than 0.");
			} else {
				account.setDeposit(deposit);
				balance(deposit, "add");
				return deposit;
			}
		} catch (NullPointerException ex) {
			System.err.println("Please enter amount for deposit!");
		}
		return BigDecimal.ZERO;
	}

	public void depositByAccNumber() {
		System.out.println("Enter account number: ");
		String accNumber = sc.next();

		account = findAccByAccNumber(accNumber);
		deposit();
		showBalance();
	}

	public void withdraw() {
		try {
			System.out.println("Enter account number: ");
			String accNumber = sc.next();

			System.out.println("Enter amount to withdraw: ");
			BigDecimal amount = sc.nextBigDecimal();

			Account acc = findAccByAccNumber(accNumber);

			if (acc == null) {
				System.out.println("This account not found!");
				return;
			}

			BigDecimal balance = acc.getBalance();
			if (amount.compareTo(BigDecimal.ZERO) > 0 && (balance.compareTo(amount) >= 0)) {
				balance(amount, "substract");
				System.out.println("Withdraw Successfully!");
				showBalance();
			} else {
				System.out.println("Withdraw Unsuccessfully!");
			}
		} catch (NullPointerException e) {
			System.err.println(e.getMessage());
		}
	}

	public void showBalance() {
		System.out.println("Balance: " + account.getBalance());
	}

	public Account findAccByAccNumber(String accNumber) {
		for (Account account : currentAccounts) {
			if (accNumber.equalsIgnoreCase(account.getAccountNumber())) {
				return account;
			}
		}

		for (Account account : savingaccounts) {
			if (accNumber.equalsIgnoreCase(account.getAccountNumber())) {
				return account;
			}
		}
		return null;
	}

	public void showTypeOfAcc() {
		List<TypeOfAccount> listTypeAcc = Arrays.asList(TypeOfAccount.values());
		int index = 1;
		for (TypeOfAccount typeOfAccount : listTypeAcc) {
			System.out.println(index + ". " + typeOfAccount);
			index++;
		}
	}

	public Account account(int choose) {
		if (choose == 1) {
			account = new SavingAccount();
			account.setTypeOfAccount(TypeOfAccount.SavingAccount);
		} else {
			account = new CurrentAccount();
			account.setTypeOfAccount(TypeOfAccount.CurrentAccount);
		}
		return account;
	}

}
