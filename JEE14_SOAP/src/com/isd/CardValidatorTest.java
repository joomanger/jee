package com.isd;

import org.junit.Assert;
import org.junit.Test;

public class CardValidatorTest {
	@Test
	public void shouldCheckCreditCardValidity() {
		CardValidator cardValidator = new CardValidator();
		CreditCard creditCard = new CreditCard("12341234", "10/10", 1234, "VISA");
		Assert.assertTrue("��������� ����� �������������", cardValidator.validate(creditCard));
		creditCard.setNumber("123 41233");
		Assert.assertFalse("��������� ����� ���������������", cardValidator.validate(creditCard));
	}
}
