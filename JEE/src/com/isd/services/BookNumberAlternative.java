package com.isd.services;

import javax.enterprise.inject.Alternative;

@Alternative
public class BookNumberAlternative implements IBookNumber {

	@Override
	public String getBookNumber() {
		// TODO Auto-generated method stub
		return "Alternative realization";
	}

}
