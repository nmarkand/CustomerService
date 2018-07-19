package com.rest.springboot.customer.repositories;

import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.rest.springboot.customer.models.CustomerModel;

@Repository
public interface ICustomerServiceRepository 
{
	public Optional<CustomerModel> addCustomer(CustomerModel customerModel);
	
	public ResponseEntity<?> removeCustomer(final String customerUuid);
	
	public Optional<CustomerModel> updateCustomer(final String customerUuid, 
			final CustomerModel customerModel);
	
}
