package com.nxpert.CustomerDemo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nxpert.CustomerDemo.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query(value="SELECT c from Customer c where lower(c.name) like lower(?1)")
	Page<Customer> search(Pageable paging, String name);

	@Query(value="SELECT  * FROM customer c where c.id IN (\n" + 
			"SELECT cc.customer_id FROM  customer_consultants cc where cc.consultants_id = ?1)",nativeQuery = true)
	Page<Customer> readByConsultantId(Pageable pageable, Integer id);
	
	
	


}
