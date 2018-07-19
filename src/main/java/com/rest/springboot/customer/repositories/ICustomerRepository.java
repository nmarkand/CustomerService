package com.rest.springboot.customer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rest.springboot.customer.models.CustomerModel;

@Repository
public interface ICustomerRepository extends JpaRepository<CustomerModel, Integer>
{
	
}
