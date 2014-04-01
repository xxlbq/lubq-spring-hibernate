package com.lubq.test.web.service;

import java.util.List;

import com.lubq.test.web.bo.Customer;

public interface ICustomerService {

	public Customer update(Customer customer);

	public Customer find(Integer id);

	public Customer findReference(Integer id);

	public Customer findCustomerByName(String name);

	public List<Customer> findAllCustomerUser();

	public boolean saveCustomer(Customer customer);
	
	public void delCustomer(Customer customer);

}