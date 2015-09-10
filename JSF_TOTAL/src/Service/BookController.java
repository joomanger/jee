package Service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import Entity.Book;
import ejb.BookEJB;

@Named
@RequestScoped
public class BookController implements Serializable {
	private static final long serialVersionUID = 712879908019724289L;
	private Book book = new Book();

	@EJB
	private BookEJB bookEJB;

	public List<Book> getAll() {
		return bookEJB.findAll();
	}

	public void createBook() {
		bookEJB.createBook(book);
	}

	public void deleteAllBook() {
		bookEJB.deleteAllBook();
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
