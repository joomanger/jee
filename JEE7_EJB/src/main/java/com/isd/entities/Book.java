package com.isd.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

/**
 * Entity implementation class for Entity: Book
 *
 */
@Entity
@NamedQuery(name = Book.FIND_ALL, query = "select b from Book b")
public class Book implements Serializable {

	public static final String FIND_ALL = "FIND_ALL";

	@Id
	@SequenceGenerator(name = "book_sq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "book_sq")
	private int id;
	private String title;
	private float price;
	private String description;
	@Version
	private Integer version;

	private static final long serialVersionUID = 1L;

	public Book() {
		super();
	}

	public Book(String title, float price, String description) {
		super();
		this.title = title;
		this.price = price;
		this.description = description;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Book title:" + title + "; price:" + price + "; desc:" + description;
	}

}
