package com.isd;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import com.isd.ejb.BookEJB;
import com.isd.ejb.MyException;
import com.isd.entities.Book;

public class Run {

	public static void main(String[] args) throws NamingException, Exception {
		// TODO Auto-generated method stub
		/*
		 * Weld weld = new Weld(); WeldContainer container = weld.initialize();
		 * BookService bookService =
		 * container.instance().select(BookService.class).get();
		 * System.out.println("Запсукаемся..."); bookService.run();
		 */

		Map<String, File> properties = new HashMap<>();
		properties.put(EJBContainer.MODULES, new File("target/classes"));

		try (EJBContainer ec = EJBContainer.createEJBContainer(properties)) {
			Context ctx = ec.getContext();

			BookEJB be = (BookEJB) ctx.lookup("java:global/classes/BookEJB");

			be.removeAll();

			Book b1 = new Book("HelloWorld1", 150.25f, "Моя книженция1");
			Book b2 = new Book("HelloWorld2", 170.25f, "Моя книженция2");
			Book b3 = new Book("HelloWorld4", 190.25f, "Моя книженция3");

			try {
				be.createBook(b1);
			} catch (MyException e) {
				System.out.println(e.getMessage());
			}
			try {
				be.createBook(b2);
			} catch (MyException e) {
				System.out.println(e.getMessage());
			}
			try {
				be.createBook(b3);
			} catch (MyException e) {
				System.out.println(e.getMessage());
			}

			for (Book b : be.findAll()) {
				System.out.println(b);
			}

		}

	}

}
