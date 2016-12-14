package rocketBase;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) throws RateException 
	{
		
		ArrayList<RateDomainModel> rates = _RateDAL.getAllRates();
		RateDomainModel whateverRate = null;
		double dRate = -1;
		for (RateDomainModel rate : rates){
			if(rate.getiMinCreditScore()==GivenCreditScore){
				dRate = rate.getdInterestRate();
				whateverRate = rate;
			}
		}
		
		if (whateverRate == null) {
			throw new RateException(whateverRate);
		}
		else{
			return dRate;
		}
		
		
	}
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return FinanceLib.pmt(r, n, p, f, t);
	}
}
