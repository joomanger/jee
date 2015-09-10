package com.isd;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import com.isd.service.BookService;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		BookService bookService = container.instance().select(BookService.class).get();
		System.out.println("Запсукаемся...");
		bookService.test();
	}

}
