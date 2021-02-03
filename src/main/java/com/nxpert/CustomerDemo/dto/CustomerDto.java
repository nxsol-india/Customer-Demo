package com.nxpert.CustomerDemo.dto;

import java.util.List;

import com.nxpert.CustomerDemo.model.Consultant;

public class CustomerDto {

	int id;
	String name;

	List<Consultant> consultants;

	public List<Consultant> getConsultants() {
		return consultants;
	}

	public void setConsultants(List<Consultant> consultants) {
		this.consultants = consultants;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
