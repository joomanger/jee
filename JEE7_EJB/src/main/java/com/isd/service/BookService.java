package com.isd.service;

import java.util.logging.Logger;

import javax.inject.Inject;

import com.isd.annotations.Loggable;

@Loggable
public class BookService {

	@Inject
	private Logger log;

	public void run() {
		log.info("Запустили");
	}

}
