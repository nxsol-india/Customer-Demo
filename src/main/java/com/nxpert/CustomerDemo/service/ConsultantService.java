package com.nxpert.CustomerDemo.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nxpert.CustomerDemo.model.Consultant;

public interface ConsultantService {

	Page<Consultant> search(Pageable pageable, String searchText);

	Page<Consultant> readAll(Pageable pageable);

	Optional<Consultant> read(Integer id);

	Consultant create(Consultant request);

	Consultant update(Consultant request);

	void delete(Integer id);

	
}
