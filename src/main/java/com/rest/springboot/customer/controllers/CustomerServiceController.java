package com.rest.springboot.customer.controllers;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rest.springboot.customer.models.CustomerModel;
import com.rest.springboot.customer.repositories.ICustomerRepository;
import com.rest.springboot.exceptions.ServiceResourceNotFoundException;
import com.rest.springboot.utils.ServiceUtil;

@RestController
@RequestMapping("/api")
public class CustomerServiceController 
{	
	private static final Logger log = LoggerFactory.getLogger(CustomerServiceController.class);
	
	@Autowired
	ICustomerRepository iCustomerRepository;
	
	@GetMapping("/customer/id/{id}")
	public Optional<CustomerModel> getCustomerById(@PathVariable(value = "id") final Integer id) 
	{		
		ServiceUtil.isNotNull(id);
		
		Optional<CustomerModel> eM = iCustomerRepository.findById(id);		
		
		if ( eM.orElse(null) != null && eM.isPresent())
		{
			return eM;
		}	
		else
		{
			log.error("Resource not found");
			
			throw new ServiceResourceNotFoundException("Customer", "id", id);	
		}				
	}
	
	@GetMapping("/customer")
	public List<CustomerModel> getCustomerList() 
	{		
			return iCustomerRepository.findAll();		
	}
	
	@PostMapping("/customer")
	@CacheEvict(cacheNames="customerList", allEntries=true)
	public @Valid CustomerModel createCustomer(@Valid @RequestBody CustomerModel customerModel) 
	{							     
		ServiceUtil.isNotNull(customerModel);
			
		return iCustomerRepository.save(customerModel);
		//OR
		//return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/customer/id/{id}")
	@CacheEvict(cacheNames="customerList", allEntries=true)
	public ResponseEntity<?> deleteCustomerByUuid(@PathVariable(value = "id") final Integer id) 
	{		
		ServiceUtil.isNotNull(id);
		
		iCustomerRepository.deleteById(id);
		
		return ResponseEntity.ok().build();

	}

	@PutMapping("/customer/uuid/{uuid}")
	@CacheEvict(cacheNames="customerList", allEntries=true)
	public Optional<CustomerModel> updateCustomerByUuid(@PathVariable(value = "id") final int id, 
			@Valid @RequestBody CustomerModel customerModel ) 
	{		
		ServiceUtil.isNotNull(id);
		ServiceUtil.isNotNull(customerModel);
		
		return null;			
	}
}
