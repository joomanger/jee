package com.isd;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import com.isd.services.BookServices;

public class Run {
	public static void main(String[] args){
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		BookServices bookServices=container.instance().select(BookServices.class).get();
		System.out.println("Запсукаемся...");
		bookServices.test();
	}
}
