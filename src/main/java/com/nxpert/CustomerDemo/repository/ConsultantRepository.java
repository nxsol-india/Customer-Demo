package com.nxpert.CustomerDemo.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nxpert.CustomerDemo.model.Consultant;

@Repository
public interface ConsultantRepository extends JpaRepository<Consultant, Integer> {

	@Query(value="SELECT c from Consultant c where lower(c.name) like lower(?1)")
	Page<Consultant> search(Pageable pageable, String queriableText);

	@Query(value="SELECT  c FROM Consultant c where c.customers IN :id ")
	Page<Consultant> readAllByCoustomerId(Pageable pageable,@Param("id") Collection<Integer> id);

}
