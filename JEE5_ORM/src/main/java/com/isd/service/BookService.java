package com.isd.service;

import java.util.ArrayList;
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
import com.isd.entities.News;
import com.isd.entities.NewsId;

@Loggable
public class BookService {

	@Inject
	private Logger log;

	public void test() {
		log.info("Запустили");

		Address address1 = new Address("Ленина 45", null, "Донецк", "Донецкая обл", "123456", "Украина");
		Address address2 = new Address("Ленина 55", null, "Донецк", "Донецкая обл", "123456", "Украина");
		List<Address> a = new ArrayList<>();
		a.add(address1);
		a.add(address2);

		Customer customer = new Customer("Oleksy", "Savin");
		customer.setAddresses(a);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JEE5_ORM");
		EntityManager em = emf.createEntityManager();
		// 3. Обеспечивает постоянство Book в базе данных
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(customer);
		tx.commit();

		// 4. Выполняет именованный запрос
		a = em.createNamedQuery("findAddressByZipCode", Address.class).getResultList();
		for (Address address : a) {
			log.info("Результат findAddressByZipCode: " + address);
		}

		// Составной первичный ключ для сущности News
		NewsId id = new NewsId("NewsTitle", "EN");
		News news = new News("NewsContent");

		news.setId(id);
		tx.begin();
		em.persist(news);
		tx.commit();
		log.info("News: " + news);

		// 5. Закрывает EntityManager и EntityManagerFactory
		em.close();
		emf.close();

	}
}
