package com.isd.produces;

import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class MyProduces {
	@Produces
	@PersistenceContext(unitName = "JEE7_EJB")
	private EntityManager em;

	@Produces
	private Logger log(InjectionPoint ip) {
		return Logger.getLogger(ip.getMember().getDeclaringClass().getName());
	}
}
