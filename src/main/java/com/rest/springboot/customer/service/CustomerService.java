package com.rest.springboot.customer.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.rest.springboot.customer.models.CustomerModel;
import com.rest.springboot.customer.repositories.ICustomerRepository;
import com.rest.springboot.customer.repositories.ICustomerServiceRepository;
import com.rest.springboot.exceptions.ServiceResourceNotCreatedOrUpdatedException;
import com.rest.springboot.exceptions.ServiceResourceNotFoundException;
import com.rest.springboot.utils.ServiceUtil;

@Service
public class CustomerService
{
	private static final Logger log = LoggerFactory.getLogger(CustomerService.class);
	
	
	private static final String CUSTOMER_CREATED = "CREATE";
	private static final String CUSTOMER_UPDATED = "UPDATE";
	private static final String CUSTOMER_DELETED = "DELETE";
	
	@Autowired
	ICustomerRepository iCustomerRepository;

	

}
