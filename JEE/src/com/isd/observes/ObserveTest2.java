package com.isd.observes;

import java.util.logging.Logger;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

public class ObserveTest2 {
	@Inject
	private Logger log;

	@SuppressWarnings("unused")
	private void test(@Observes String msg) {
		log.info("---ObserveTest2: " + msg);
		// TODO Auto-generated constructor stub
	}

}
