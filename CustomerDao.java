package com.foodplaza.dao;

import java.util.List;

import com.foodplaza.pojo.Customer;

public interface CustomerDao
{
	boolean addCustomer(Customer c);
	
	boolean updateCustomer(Customer c);
	
	boolean deleteCustomer(int customerId);
	
	List<Customer> displayAllCustomer();
	
	Customer displayCustomerById(int customerId);
	
	List<Customer>displayCustomerByName(String customerName);
	
	List<Customer>displayCustomerByCity(String customerCity);
	
	Customer displayCustomerByAddress(String customerAddress);
	
	Customer displayCustomerByContactNo(Long customerContactNo);
	
	Customer displayCustomerByEmailId(String customerEmailId);
	
}
