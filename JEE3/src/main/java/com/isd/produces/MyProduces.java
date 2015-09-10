package com.isd.produces;

import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class MyProduces {
	@Produces
	private int test = 5;

	@Produces
	private String name = "JGHjbsjdhbjalexdbjshfgwjb";

	@Produces
	private Logger log(InjectionPoint ip) {
		return Logger.getLogger(ip.getMember().getDeclaringClass().getName());
	}
}
