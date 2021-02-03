package com.nxpert.CustomerDemo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.nxpert.CustomerDemo.model.Consultant;
import com.nxpert.CustomerDemo.model.Customer;

@Repository
public interface ConsultantRepository extends JpaRepository<Consultant, Integer> {

	@Query(value="SELECT  * from consultant c where c.name = ?1",nativeQuery = true)
	Page<Consultant> search(String name,Pageable paging);

}
