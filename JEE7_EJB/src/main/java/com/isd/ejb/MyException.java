package com.isd.ejb;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class MyException extends Exception {

	private static final long serialVersionUID = 3723650121541062655L;

	public MyException() {

	}

	public MyException(String msg) {
		super(msg);
	}
}