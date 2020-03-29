package testBanke;

import java.util.ArrayList;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Practice_0327 {

	@Test
	public void testiranjeKonstruktora() {
		Account nalog = new Account("Vladin racun", "200-689-15");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(nalog.getName(), "Vladin racun");
		sa.assertEquals(nalog.getNumber(), "200-689-15");
		sa.assertAll();
	}

	@Test
	public void testiranjeNaloga() {
		Account[] nalozi = new Account[100];
		SoftAssert sa = new SoftAssert();
		for (int i = 0; i < nalozi.length; i++) {
			nalozi[i] = new Account("Vladan" + i);
		}
		for (int i = 0; i < nalozi.length; i++) {
			String broj = nalozi[i].getNumber();
			for (int j = i + 1; j < nalozi.length; j++) {
				sa.assertNotEquals(broj, nalozi[j].getNumber());
			}
		}
		sa.assertAll();
	}
	
	@Test
	public void testiranjeBanke() {
		Bank mtsBanka = new Bank();
		int genId = 0;
/*		Account[] br = new Account[5];
		SoftAssert sa = new SoftAssert();
		for (int i =0; i<br.length; i++) {
		br[i] = prva.openAccount("Vladan");
		}
		for (int i = 0; i<br.length; i++) {
			sa.assertEquals(prva.getSumMoney(), 0d);
		}*/
		Account tempAcc;
		for (int i =0; i<5; i++) {
			mtsBanka.openAccount("ACC000" + genId++);
		}
		sa.assertAll();
		
		
		
	}
}
