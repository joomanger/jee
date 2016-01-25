package com.isd;

import javax.jws.WebService;

@WebService
public interface Validator {
	public boolean validate(CreditCard creditCard);

}
