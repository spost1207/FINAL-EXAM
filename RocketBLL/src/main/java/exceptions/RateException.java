package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {

	private RateDomainModel WhateverRate;
	
	public RateException(RateDomainModel whateverRate) {
		super();
		WhateverRate = whateverRate;
	}

	public RateDomainModel getRateDomainModel() {
		return WhateverRate;
	}
}
