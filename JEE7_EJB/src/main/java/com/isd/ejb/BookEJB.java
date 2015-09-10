package com.isd.ejb;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import com.isd.entities.Book;

/*
 * EJB - содержит все глаголы применимые к объекту - вставка в бд, удаление из
 * бд, поиск в бд, обновление в бд
 */

/*
 * Также именно EJB класс проверяет сможет ли тот или иной юзер задействовать
 * тот или иной метод
 */

@Stateless
// @TransactionAttribute(TransactionAttributeType.REQUIRED)
// TransactionManagementType.CONTAINER транзакциями управляет контейнер EJB
// TransactionManagementType.BEAN транзакциями управляет компонент
@TransactionManagement(TransactionManagementType.BEAN)
public class BookEJB {

	@Resource // Только для TransactionManagementType.BEAN
	private UserTransaction ut;

	@Resource
	private SessionContext ctx;

	@Inject
	private EntityManager em;

	public BookEJB() {
		super();
	}

	public void createBook(Book book) throws Exception {
		try {
			ut.begin();
			em.persist(book);
			ut.commit();
		} catch (Exception e) {
			ut.rollback();
			;
		}

		if (1 == 1) { // ctx.setRollbackOnly();
			// откат транзакции
			throw new MyException("Исключение в createBook. Откатываем транзакцию");
		}

	}

	public void removeBook(Book book) {
		em.remove(book);
	}

	public void removeAll() throws Exception {
		try {
			ut.begin();
			em.createQuery("delete from Book").executeUpdate();
			ut.commit();
		} catch (Exception e) {
			ut.rollback();
		}
	}

	public void updateBook(Book book) {
		em.merge(book);
	}

	// @TransactionAttribute(TransactionAttributeType.SUPPORTS)
	/*
	 * если только чтение с БД
	 */
	public List<Book> findAll() {
		return em.createNamedQuery(Book.FIND_ALL, Book.class).getResultList();
	}

}
