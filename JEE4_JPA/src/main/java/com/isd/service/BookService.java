package com.isd.service;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.isd.annotations.Loggable;
import com.isd.entities.Book;

@Loggable
public class BookService {

	@Inject
	private Logger log;

	public void test() {
		log.info("���������");

		Book book = new Book("Title", 150.25f, "This is my book");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JEE4_JPA");
		EntityManager em = emf.createEntityManager();
		// 3. ������������ ����������� Book � ���� ������
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(book);
		tx.commit();
		// 4. ��������� ����������� ������
		book = em.createNamedQuery("findBookByTitle", Book.class).getSingleResult();
		log.info("��������� findBookByTitle: " + book);
		// 5. ��������� EntityManager � EntityManagerFactory
		em.close();
		emf.close();

	}
}
