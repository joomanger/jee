package com.isd;

import java.rmi.RemoteException;

public class Run {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		CreditCard cc = new CreditCard("4455668", "0108", 123, "VISA");
		ValidatorProxy proxy = new ValidatorProxy();
		System.out.println(String.valueOf(proxy.validate(cc)));
	}
}
