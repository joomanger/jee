package com.isd.service;

import java.util.Set;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.constraints.Max;

import com.isd.annotations.CStrName;
import com.isd.annotations.Loggable;

@Loggable
public class BookService {

	@Inject
	private Logger log;

	@Inject
	@Max(5)
	private int test;

	@Inject
	@CStrName
	private String name;

	@Inject
	private Validator validator;

	public void test() {
		log.info("Запустили");
		Set<ConstraintViolation<BookService>> violations = validator.validate(this);
		if (violations.size() > 0)
			for (ConstraintViolation<BookService> v : violations) {
				log.info("Error: "+v.getMessage());
			}
		else {

			log.info("Проверка ограничений прошла успешно! "+name);
		}
	}
}
