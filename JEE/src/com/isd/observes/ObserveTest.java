package com.isd.observes;

import java.util.logging.Logger;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

public class ObserveTest {
	@Inject
	private Logger log;

	@SuppressWarnings("unused")
	private void stringTest(@Observes String msg) {
		log.info("---ObserveTest: " + msg);
	}
}
