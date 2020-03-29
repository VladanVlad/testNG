package banka_test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import banka.Account;
import banka.Bank;

public class BankTest {
	SoftAssert sa = new SoftAssert();

	@Test
	public void testKonstruktoraBanka() {
		Bank postanska = new Bank();
		Account[] nalog = new Account[5];
		for (int i = 0; i < nalog.length; i++) {
			nalog[i] = new Account("Vladan" + i);
			sa.assertEquals("Vladan" + i, nalog[i].getName());
		}
		sa.assertAll();
	}

	@Test
	public void testSetMoneyBank() {
		Bank otp = new Bank();
		Account nalog = otp.openAccount("Vladan");
		nalog.setAmount(100000d);
		sa.assertEquals(100000d, nalog.getAmount());
		sa.assertAll();
	}

	@Test
	public void testTransferBank() {
		Bank prva = new Bank();
		Account s1 = prva.openAccount("ivana");
		Account s2 = prva.openAccount("milica");
		s1.setAmount(10000.0);
		prva.transferMoney(s1.getNumber(), s2.getNumber(), 1000d);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(s1.getAmount(), 9000d);
		sa.assertEquals(s2.getAmount(), 1000d);
		sa.assertAll();
	}

	@Test
	public void testSumMoneyBank() {
		Bank erste = new Bank();
		Account nalog = erste.openAccount("Vladan");
		Account nalog2 = erste.openAccount("Marko");
		Account nalog3 = erste.openAccount("Dejan");
		nalog.setAmount(10000d);
		nalog2.setAmount(25000d);
		nalog3.setAmount(15000d);
		sa.assertEquals(50000d, erste.getSumMoney());
	}
}
