package com.isd.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

@Entity
@NamedQuery(name = Address.FIND_ALL, query = "select a from Address a")
public class Address implements Serializable {

	private static final long serialVersionUID = 51915817602629450L;

	public static final String FIND_ALL = "Address.findAll";

	@Id
	@SequenceGenerator(name = "address_sq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "address_sq")
	private Long id;
	private String street;
	private String city;
	private String country;
	@Version
	private int version;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String street, String city, String country) {
		super();
		this.street = street;
		this.city = city;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return street + " " + city + " " + country;
	}

}
