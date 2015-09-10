package com.isd.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.SequenceGenerator;

/**
 * Entity implementation class for Entity: Address
 *
 */
@Entity
@SecondaryTables({ @SecondaryTable(name = "city"), @SecondaryTable(name = "country") })
@NamedQuery(name = "findAddressByZipCode", query = "select b from Address b where b.zipcode='123456'")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "address_sq", initialValue = 5, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sq")
	private Long id;
	private String street1;
	private String street2;
	@Column(table = "city")
	private String city;
	@Column(table = "city")
	private String state;
	@Column(table = "city")
	private String zipcode;
	@Column(table = "country")
	private String country;

	public Address() {
		super();
	}

	public Address(String street1, String street2, String city, String state, String zipcode, String country) {
		super();
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Address street1:" + street1 + "; zipcode:" + zipcode + "; country:" + country + "; city:" + city
				+ "; state:" + state;
	}

}
