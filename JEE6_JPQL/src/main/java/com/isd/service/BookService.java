package com.isd.service;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.isd.annotations.Loggable;
import com.isd.entities.Address;
import com.isd.entities.Customer;

@Loggable
public class BookService {

	@Inject
	private Logger log;

	public void test() {
		log.info("Запустили");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JEE6_JPQL");
		EntityManager em = emf.createEntityManager();

		Address a = new Address("Гагарина", "Авдеевка", "Украина");

		Customer c = new Customer("Алексей", "Савин", a);

		EntityTransaction tr = em.getTransaction();
		tr.begin();
		em.persist(c);
		tr.commit();
		System.out.println(c);

		c.setFirstName("Марк");

		em.refresh(c); // убирает все изменения сущности, взяв данные из бд,
						// flush() наоборот сбрасывает сущность в БД но не
						// делает коммит

		System.out.println(c);

		List<Address> as = em.createNamedQuery(Address.FIND_ALL, Address.class).getResultList();

		for (Address adr : as) {
			System.out.println(adr);
		}

		/*
		 * tr.begin(); em.remove(c); tr.commit();
		 */

	}
}
