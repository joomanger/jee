package com.isd.services;

import java.util.logging.Logger;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import com.isd.annotations.Loggable;

@Loggable
public class BookServices {
	@Inject
	private String name;

	@Inject
	private int age;

	@Inject
	private Logger log;
	
	@Inject
	private Event<String> test;
	
	@Inject //@BookR1
	private IBookNumber bookNumber;

	public void test() {
		test.fire("Send: Hello World");
		log.info("BookNumber: " + bookNumber.getBookNumber() + "; Name: " + name + "; Age: " + age);
	}
}
