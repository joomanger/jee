package com.isd.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * Entity implementation class for Entity: Book
 *
 */
@Entity
@NamedQuery(name = "findBookByTitle", query = "select b from Book b where b.title='Title'")
public class Book implements Serializable {

	@Id
	@GeneratedValue
	private int id;
	private String title;
	private float price;
	private String description;
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Book title:" + title + "; price:" + price + "; desc:" + description;
	}

}
