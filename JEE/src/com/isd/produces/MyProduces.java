package com.isd.produces;

import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class MyProduces {
	@Produces
	private String name = "Oleksiy";
	@Produces
	private int age = 34;

	@Produces
	private Logger log(InjectionPoint ip) {
		return Logger.getLogger(ip.getMember().getDeclaringClass().getName());
	}
}
