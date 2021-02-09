package com.nxpert.CustomerDemo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.JoinColumn;

@Entity
@Table(name = "customer")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id",scope = Customer.class)
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true)
	Integer id;

	@Column(name = "name")
	String name;

	@ManyToMany(targetEntity = Consultant.class, 
			fetch = FetchType.EAGER,
	        cascade = {CascadeType.MERGE} 
				)
	@JoinTable(name = "customer_consultants", 
				joinColumns = {
								@JoinColumn(name = "customer_id") 
							  }, inverseJoinColumns = { @JoinColumn(name = "consultants_id") }
			  )
	@JsonIdentityReference(alwaysAsId = true)
	List<Consultant> consultants;


	public List<Consultant> getConsultants() {
		return consultants;
	}

	public void setConsultants(List<Consultant> consultants) {
		this.consultants = consultants;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
