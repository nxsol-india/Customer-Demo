package com.nxpert.CustomerDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.nxpert.CustomerDemo.model.Consultant;
import com.nxpert.CustomerDemo.model.Customer;

public interface ConsultantService {

	public Page<Consultant> readAll();

	public Optional<Consultant> read(int id);

	public Consultant create(Consultant consultant);

	public void delete(int id);

	public Consultant update(Consultant consultant);

	public Page<Consultant> search(String name);
}
