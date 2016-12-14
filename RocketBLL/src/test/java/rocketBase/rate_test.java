package rocketBase;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.RateException;

public class rate_test {

	@Test
	public void RateKnownTest() throws RateException {
		assertEquals(RateBLL.getRate(750),3.75,.01);
		assertEquals(RateBLL.getRate(800),3.5,.01);
		//Testing two to make sure i did it correctly.
	}
	
	@Test(expected = RateException.class)
	public void RateUnknownTest() throws RateException {
		RateBLL.getRate(750);
	}
	
	@Test
	public void getPaymentTesting() {
		equals(RateBLL.getPayment(0.04, 360, 300000, 0, true) == 1432.25);
	}


}
