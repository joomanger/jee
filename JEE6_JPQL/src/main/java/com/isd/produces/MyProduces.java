package com.isd.produces;

import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class MyProduces {
	
	@Produces
	@PersistenceContext(name="JEE6_JPQL")
	private EntityManager em;
	
	@Produces
	private Logger log(InjectionPoint ip) {
		return Logger.getLogger(ip.getMember().getDeclaringClass().getName());
	}
}
