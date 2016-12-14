package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import rocketDomain.RateDomainModel;

public class Rate_Test {

	@Test
	public void test() {
		
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		System.out.println ("Rates size: " + rates.size());
		assert(rates.size() > 0);
		
		assert(1==1);
		
		assertEquals(rates.get(0).getdInterestRate(),5.00,.01);
		assertEquals(rates.get(1).getdInterestRate(),4.50,.01);
		assertEquals(rates.get(2).getdInterestRate(),4.00,.01);
		assertEquals(rates.get(3).getdInterestRate(),3.75,.01);
		assertEquals(rates.get(4).getdInterestRate(),3.50,.01);
		
	}

}
