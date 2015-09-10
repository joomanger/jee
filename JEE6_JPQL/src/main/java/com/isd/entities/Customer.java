package com.isd.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

import com.isd.listeners.CustomerValidation;

/**
 * Entity implementation class for Entity: Customer
 *
 */
@EntityListeners(CustomerValidation.class)
@Entity
public class Customer implements Serializable {

	private static final long serialVersionUID = 1089765770171998573L;

	@Id
	@SequenceGenerator(name = "customer_sq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "customer_sq")
	private Long id;
	private String firstName;
	private String lastName;

	@Version
	private int version;

	// orphanRemoval обязательно удалит address при удалении customer(также
	// можно воспользховаться типом каскадирования REMOVE)
	@OneToOne(cascade = { CascadeType.PERSIST,
			CascadeType.REMOVE }/* , orphanRemoval = true */)
	@JoinColumn(name = "address_fk")
	private Address address;

	public Customer() {
		super();
	}

	public Customer(String firstName, String lastName, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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
		return firstName + " " + lastName;
	}

}
