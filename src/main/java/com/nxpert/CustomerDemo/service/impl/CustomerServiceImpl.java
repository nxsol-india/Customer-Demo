package com.nxpert.CustomerDemo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nxpert.CustomerDemo.model.Customer;
import com.nxpert.CustomerDemo.repository.CustomerReopository;
import com.nxpert.CustomerDemo.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerReopository reopository;
	
	@Override
	public Page<Customer> search(Pageable pageable, String searchText) {
		// TODO Auto-generated method stub
		String queriableText = new StringBuilder("%").append(searchText).append("%").toString();
		return reopository.search(pageable, queriableText);
	}
	
	@Override
	public Page<Customer> readAll(Pageable pageable) {
		return reopository.findAll(pageable);
	}
	
	@Override
	public Optional<Customer> read(Integer id) {
		return reopository.findById(id);
	}
	
	@Override
	public Customer create(Customer request) {
		return reopository.save(request);
	}

	@Override
	public Customer update(Customer request) {
		Customer customer = reopository.getOne(request.getId());
		customer.setName(request.getName());
		customer.setId(request.getId());
		return reopository.save(customer);
	}

	@Override
	public void delete(Integer id) {
		reopository.deleteById(id);
	}
}
