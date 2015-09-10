package com.isd.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.isd.annotations.CStrName;

public class MyValidateName implements ConstraintValidator<CStrName, String> {

	@Override
	public void initialize(CStrName constraintAnnotation) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if (value.contains("alex"))
			return true;
		return false;
	}

}
