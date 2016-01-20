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
		log.info("���������");

		Address address1 = new Address("������ 45", null, "������", "�������� ���", "123456", "�������");
		Address address2 = new Address("������ 55", null, "������", "�������� ���", "123456", "�������");
		List<Address> a = new ArrayList<>();
		a.add(address1);
		a.add(address2);

		Customer customer = new Customer("Oleksy", "Savin");
		customer.setAddresses(a);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JEE5_ORM");
		EntityManager em = emf.createEntityManager();
		// 3. ������������ ����������� Book � ���� ������
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(customer);
		tx.commit();

		// 4. ��������� ����������� ������
		a = em.createNamedQuery("findAddressByZipCode", Address.class).getResultList();
		for (Address address : a) {
			log.info("��������� findAddressByZipCode: " + address);
		}

		// ��������� ��������� ���� ��� �������� News
		NewsId id = new NewsId("NewsTitle", "EN");
		News news = new News("NewsContent");

		news.setId(id);
		tx.begin();
		em.persist(news);
		tx.commit();
		log.info("News: " + news);

		// 5. ��������� EntityManager � EntityManagerFactory
		em.close();
		emf.close();

	}
}
