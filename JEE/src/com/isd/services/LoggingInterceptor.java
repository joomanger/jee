package com.isd.services;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import com.isd.annotations.Loggable;

@Interceptor
@Loggable
public class LoggingInterceptor {
	@Inject
	private Logger log;

	@AroundConstruct
	private Object init(InvocationContext ic) throws Exception {
		log.info("Entering constructor");
		try {
			return ic.proceed();

		} finally {
			// TODO: handle finally clause
			log.info("Exiting constructor");
		}
	}

	@AroundInvoke
	private Object logMethod(InvocationContext ic) throws Exception {
		log.info("---------Entering "+ic.getTarget()+" : "+ ic.getMethod().toString());
		try {
			return ic.proceed();
		} finally {
			// : handle finally clause
			log.info("---------Exiting "+ic.getTarget()+" : "+ic.getMethod().toString());
		}
	}

}
