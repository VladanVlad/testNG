package testBanke;

import java.util.ArrayList;

public class Bank {
	private ArrayList<Account> accounts;

	public Bank() {
		accounts = new ArrayList<Account>();  //rezervisano mesto u memoriji za listu
	}

	public void openAccount(String name) {
		Account account = new Account(name);
		accounts.add(account);
	}

	public void closeAccount(Account account) {
		accounts.remove(account);
	}

	public boolean transferMoney(String accountNumberFrom, String accountNumberTo, Double amount) {
		Account from = getAccount(accountNumberFrom);
		if (from != null)
			from.setAmount(from.getAmount() - amount);
		Account to = getAccount(accountNumberTo);
		if (to != null)
			to.setAmount(to.getAmount() + amount);
		return true;
	}

	public void payInMoney(String accountNumber, Double amount) {
		Account account = getAccount(accountNumber);
		if (account != null)
			account.setAmount(account.getAmount() + amount);
	}

	public Account getAccount(String accountNumber) {
		for (Account acc : accounts)
			if (acc.getNumber() == accountNumber)
				return acc;

		return null;
	}

	public Double getSumMoney() {
		Double res = 0d;
		for (int i = 0; i < accounts.size(); i++) {
			res += accounts.get(i).getAmount();
		}
		return res;
	}

	public void reset() {
		accounts.clear();
	}

}
