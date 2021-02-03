package com.nxpert.CustomerDemo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nxpert.CustomerDemo.model.Consultant;
import com.nxpert.CustomerDemo.model.Customer;
import com.nxpert.CustomerDemo.repository.ConsultantRepository;
import com.nxpert.CustomerDemo.service.ConsultantService;

@Service
public class ConsultantServiceImpl implements ConsultantService {

	@Autowired
	ConsultantRepository dao;

	@Override
	public Page<Consultant> readAll() {
		Pageable paging = PageRequest.of(0, 1);

		Page<Consultant> listOfConsulatant = dao.findAll(paging);
		return listOfConsulatant;
	}

	@Override
	public Optional<Consultant> read(int id) {
		return dao.findById(id);
	}

	@Override
	public Consultant create(Consultant consultant) {
		return dao.save(consultant);
	}

	@Override
	public void delete(int id) {
		dao.deleteById(id);
	}

	@Override
	public Consultant update(Consultant consultant) {
		Consultant cons = dao.getOne(consultant.getId());
		cons.setName(consultant.getName());
		cons.setId(consultant.getId());
		return dao.save(cons);
	}

	@Override
	public Page<Consultant> search(String name) {
		Pageable paging = PageRequest.of(0, 1);
		return dao.search(name,paging);
	}


}
