package ejb;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.Book;

/**
 * Session Bean implementation class BookEJB
 */

@Stateless
public class BookEJB implements Serializable {

	private static final long serialVersionUID = 8136153976443581527L;
	@PersistenceContext(unitName = "JSF_TOTAL")
	private EntityManager em;
	
	public BookEJB() {
		// TODO Auto-generated constructor stub
	}

	public Book createBook(Book book) {
		em.persist(book);
		return book;
	}

	public void deleteBook(Book book) {
		em.remove(book);
	}

	public void deleteAllBook() {
		em.createQuery("delete from Book").executeUpdate();
	}
	
	public float getTotal(){
		return (float) em.createNativeQuery("select sum(price) from Book").getSingleResult();
	}

	public void updateBook(Book book) {
		em.merge(book);
	}

	public List<Book> findAll() {
		return em.createNamedQuery(Book.FIND_ALL, Book.class).getResultList();
	}

}
