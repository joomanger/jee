package com.isd.listeners;

import javax.persistence.PrePersist;

import com.isd.entities.Customer;

public class CustomerValidation {

	@PrePersist
	private void validate(Customer customer) {
		if (customer.getFirstName().equals("Алексей")) {
			customer.setFirstName("АЛЁЖКА");
		}

	}

}
