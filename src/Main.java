import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.likelion.management.AccountManagement;
import com.likelion.management.BankManagement;
import com.likelion.model.Account;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankManagement bankManagement = new BankManagement();
		AccountManagement accManagement = new AccountManagement();
		Account acc;

		List<Account> accountList = new ArrayList<>();
		accountList = bankManagement.getList();

		List<Account> savingAcc = new ArrayList<>();
		savingAcc = accManagement.getSavingList();

		List<Account> currentAcc = new ArrayList<>();
		currentAcc = accManagement.getCurrentList();

		acc = accManagement.createAccount();
		accountList.add(acc);

		for (Account account : accountList) {
			System.out.println(account.toString());
		}

		System.out.println("----Deposit-----");
		accManagement.depositByAccNumber();
		System.out.println("\n");
		System.out.println("----Withdraw-----");
		accManagement.withdraw();

		for (Account account : accountList) {
			System.out.println(account.toString());
		}

		acc = accManagement.createAccount();
		accountList.add(acc);

		for (Account account : accountList) {
			System.out.println(account.toString());
		}

		System.out.println("----Deposit-----");
		accManagement.depositByAccNumber();
		System.out.println("\n");
		System.out.println("----Withdraw-----");
		accManagement.withdraw();

		for (Account account : accountList) {
			System.out.println(account.toString());
		}
	}

}
