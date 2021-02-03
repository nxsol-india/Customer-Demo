package com.nxpert.CustomerDemo.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.nxpert.CustomerDemo.model.Consultant;
import com.nxpert.CustomerDemo.service.ConsultantService;

@RestController
@RequestMapping("/consultant")
public class ConsultantController {

	@Autowired
	ConsultantService consultantService;

	@GetMapping("/search")
	public Page<Consultant> search(@RequestParam("name") String name) {
		return consultantService.search(name);
	}
	
	@GetMapping("/readAll")
	public Page<Consultant> readAll() {
		return consultantService.readAll();
	}

	@GetMapping("/read")
	public Optional<Consultant> read(@RequestParam("id") int id) {
		return consultantService.read(id);
	}

	@PostMapping("/create")
	public Consultant create(@RequestBody Consultant consultant) {
		return consultantService.create(consultant);
	}

	@DeleteMapping("/delete")
	public String create(@RequestParam("id") int id) {
		consultantService.delete(id);
		return "data is deleted from database";
	}

	@PutMapping("/update")
	public Consultant update(@RequestBody Consultant consultant) {
		return consultantService.update(consultant);
	}

}
