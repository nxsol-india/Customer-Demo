package com.nxpert.CustomerDemo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.nxpert.CustomerDemo.dto.CustomerDto;
import com.nxpert.CustomerDemo.model.Consultant;
import com.nxpert.CustomerDemo.model.Customer;

@Component
public class ModelToDto {

	/*
	 * public List<CustomerDto> convertModelToDto(List<Customer> listOfCustomer) {
	 * List<CustomerDto> customerDtos = new ArrayList<CustomerDto>(); for (Customer
	 * customer : listOfCustomer) { CustomerDto customerDto = new CustomerDto();
	 * BeanUtils.copyProperties(customer, customerDto);
	 * customerDtos.add(customerDto);
	 * 
	 * } return customerDtos; }
	 */

	public List<CustomerDto> convertModelToDto(List<Customer> listOfCustomer) {
		List<CustomerDto> customerDtos = new ArrayList<CustomerDto>();
		for (Customer customer : listOfCustomer) {
			CustomerDto customerDto = new CustomerDto();
			BeanUtils.copyProperties(customer, customerDto);
			customerDtos.add(customerDto);
		}
		return customerDtos;
	}
	
	/*
	 * public List<CustomerDto> convertConslatantToDto(List<Consultant>
	 * listOfConsultant) { List<ConsultantDto> listOfConsultantDto = new
	 * ArrayList<ConsultantDto>(); for (Consultant customer : listOfConsultant) {
	 * ConsultantDto customerDto = new ConsultantDto();
	 * BeanUtils.copyProperties(customer, customerDto);
	 * listOfConsultantDto.add(customerDto); } return customerDtos; }
	 */


}
