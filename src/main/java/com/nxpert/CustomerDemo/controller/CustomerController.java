package com.nxpert.CustomerDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.nxpert.CustomerDemo.model.Customer;
import com.nxpert.CustomerDemo.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	CustomerService service;
	
	@GetMapping("/search")
	public Page<Customer> search(Pageable pageable, @RequestParam(name = "searchText", value = "", required = false) String searchText) {
		return service.search(pageable, searchText);
	}
	
	@GetMapping("")
	public Page<Customer> readAll(Pageable pageable) {
		return service.readAll(pageable);
	}
	
	@GetMapping("/{id}")
	public Customer read(@PathVariable Integer id) {
		return service.read(id).orElse(null);
	}

	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody Customer request) {
		return new ResponseEntity<Customer>(service.create(request), HttpStatus.CREATED);
	}

	@PutMapping("")
	public ResponseEntity<?> update(@RequestBody Customer request) {
		if(null == request.getId()) {
			return new ResponseEntity<Exception>(new Exception("Invalid Customer"),HttpStatus.BAD_GATEWAY);
		}
		return new ResponseEntity<Customer>(service.update(request), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
