package com.rest.springboot.customer.repositories;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.rest.springboot.customer.models.CustomerModel;


@Repository
public interface ICustomerRepository extends JpaRepository<CustomerModel, Integer>
{

	public static final String CUSTOMER_TABLE = "tbl_customer";
	
	@Query(value = "SELECT * FROM "+ CUSTOMER_TABLE +  " WHERE DELETED != 0 AND id = ?1", nativeQuery = true)
	CustomerModel findCustomerByID(final Integer id);

	
	@Cacheable("customerList")
	@Query(value = "SELECT * FROM "+ CUSTOMER_TABLE +  " WHERE DELETED = 0", nativeQuery = true)
	List<CustomerModel> findCustomerList();
}
