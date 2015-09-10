package Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import org.apache.bval.constraints.NotEmpty;

@Entity
@NamedQuery(name = Book.FIND_ALL, query = "select b from Book b")
public class Book implements Serializable {

	private static final long serialVersionUID = 6170257299256037577L;
	public static final String FIND_ALL = "FIND_ALL";
	@Id
	@SequenceGenerator(name = "book_sq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "book_sq", strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotEmpty(message = "Обязательно для заполнения!")
	@Size(min = 3, max = 25, message = "Длина поля от 3 до 25 символов")
	private String title;

	@NotEmpty(message = "Обязательно для заполнения!")
	private float price;

	@Version
	private int version;

	public Book() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String toString() {
		return "Book title: " + title + ", price: " + price;
	}

}
