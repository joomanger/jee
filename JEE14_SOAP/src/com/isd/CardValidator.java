package com.isd;

import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(endpointInterface = "com.isd.Validator")
public class CardValidator implements Validator {

	@Override
	@WebResult(name = "IsValid")
	public boolean validate(CreditCard creditCard) {
		// TODO Auto-generated method stub
		Character lastDigit = creditCard.getNumber().charAt(creditCard.getNumber().length() - 1);
		if (Integer.parseInt(lastDigit.toString()) % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

}
