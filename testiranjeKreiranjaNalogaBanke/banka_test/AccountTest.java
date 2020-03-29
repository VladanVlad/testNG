package banka_test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import banka.Account;
import banka.Bank;

public class AccountTest {
	SoftAssert sa = new SoftAssert();
	String ime = "Ivana";
	String broj = "200-68352411-11";

	@Test
	public void testKonstruktor1() {
		Account racun = new Account(ime, broj);
		sa.assertEquals(racun.getName(), ime);
		sa.assertEquals(racun.getNumber(), broj);
		sa.assertEquals(racun.getAmount(), 0d);
		sa.assertAll();
	}

	@Test
	public void testSetGetMetoda() {
		Account racun = new Account(ime, broj);
		racun.setAmount(10000d);
		sa.assertEquals(racun.getAmount(), 10000d);
		sa.assertAll();
	}

	@Test
	public void testToString() {
		Account racun = new Account(ime, broj);
		SoftAssert sa = new SoftAssert();
		racun.setAmount(25000d);
		sa.assertEquals(racun.toString(), broj + "\t" + ime + "\t" + String.format("%.2f", racun.getAmount()));
		sa.assertAll();
	}

	@Test
	public void testiranjeKonstruktoraBrojevaRacuna() {
		Account[] racun = new Account[50];
		for (int i = 0; i < racun.length; i++) {
			racun[i] = new Account("Marko" + i);
		}
		for (int i = 0; i < racun.length; i++) {
			String broj = racun[i].getNumber();
			for (int j = i + 1; j < racun.length; j++) {
				sa.assertNotEquals(broj, racun[j].getNumber());
			}
		}
		sa.assertAll();
	}
}