package com.foodplaza.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.foodplaza.daoimpl.CustomerDaoImpl;
import com.foodplaza.pojo.Customer;

public class CustomerMain
{
	public static void main(String[] args)
	{
		CustomerDaoImpl cdi = new CustomerDaoImpl();
		boolean flag;
		String customerName,customerEmailId,customerCity,customerAddress;
		long customerContactNo;
		int customerId,choice;
		
		List<Customer> al = new ArrayList<>();
		Customer c = new Customer();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("    *******WELCOME!!!*******");
		do {
		System.out.println("\n1.Add Customer\n2.Update Customer\n3.Delete Customer\n4.Display All Customer\n5.Display Customer By Id\n6.Display Customer By Name\n7.Display Customer By Address\n8.Display Customer By City\n9.Display Customer By Email-Id\n10.Display Customer By Contact-no\n11.Exit");
		System.out.println("\nEnter Your Choice:");
		choice = sc.nextInt();
		
		switch(choice)
		{
		case 1:
			System.out.println("Enter Your Name:");
			customerName = sc.next();
			
			System.out.println("Enter Your Email-Id:");
			customerEmailId = sc.next();
			
			System.out.println("Enter Your City:");
			customerCity = sc.next();
			
			System.out.println("Enter Your Address:");
			customerAddress = sc.next();
			
			System.out.println("Enter Your Contact No:");
			customerContactNo = sc.nextLong();
			
			c.setCustomerName(customerName);
			c.setCustomerEmailId(customerEmailId);
			c.setCustomerCity(customerCity);
			c.setCustomerAddress(customerAddress);
			c.setCustomerContactNo(customerContactNo);
			
			flag = cdi.addCustomer(c);
			if(flag)
			{
				System.out.println("Customer Added Successfully!!!\n");
			}
			
			else
			{
				System.out.println("Customer Adding Failed!!!\n");
			}
			break;
			
		case 2:
			System.out.println("Enter Customer Id:");
			customerId = sc.nextInt();
			
			System.out.println("Enter Your Name:");
			customerName = sc.next();
			
			System.out.println("Enter Your Email-Id:");
			customerEmailId = sc.next();

			System.out.println("Enter Your City:");
			customerCity = sc.next();
			
			System.out.println("Enter Your Address:");
			customerAddress = sc.next();
			
			System.out.println("Enter Your Contact No:");
			customerContactNo = sc.nextLong();
			
			c.setCustomerId(customerId);
			c.setCustomerName(customerName);
			c.setCustomerEmailId(customerEmailId);
			c.setCustomerCity(customerCity);
			c.setCustomerAddress(customerAddress);
			c.setCustomerContactNo(customerContactNo);
			
			flag = cdi.updateCustomer(c);
			if(flag)
			{
				System.out.println("Customer Updated Successfully!!!");
			}
			
			else
			{
				System.out.println("Customer Updation Failed!!!");
			}
			break;
			
		case 3:
			System.out.println("Enter Customer Id:");
			customerId = sc.nextInt();
			
			c.setCustomerId(customerId);
			
			flag = cdi.deleteCustomer(customerId);
			if(flag)
			{
				System.out.println("Customer Deleted Successfully!!!");
			}
			
			else
			{
				System.out.println("Customer Deletion Failed!!!");
			}
			break;
			
		case 4:
			al = cdi.displayAllCustomer();
			for(Customer c1:al)
			{
				System.out.println(c1.getCustomerId()+" "+c1.getCustomerName()+" "+c1.getCustomerEmailId()+" "+c1.getCustomerCity()+" "+c1.getCustomerAddress()+" "+c1.getCustomerContactNo());
			}
			break;
			
		case 5:
			System.out.println("Enter Customer Id:");
			customerId = sc.nextInt();
			
			c = cdi.displayCustomerById(customerId);
			System.out.println(c.getCustomerId()+" "+c.getCustomerName()+" "+c.getCustomerEmailId()+" "+c.getCustomerCity()+" "+c.getCustomerAddress()+" "+c.getCustomerContactNo());
			
			break;
			
		case 6:
			System.out.println("Enter Customer Name:");
			customerName = sc.next();
			al = cdi.displayCustomerByName(customerName);
			for(Customer c1:al)
			{
				System.out.println(c1.getCustomerId()+" "+c1.getCustomerName()+" "+c1.getCustomerEmailId()+" "+c1.getCustomerCity()+" "+c1.getCustomerAddress()+" "+c1.getCustomerContactNo());
			}
			break;
			
		case 7:
			System.out.println("Enter Customer Address:");
			customerAddress = sc.next();
			
			c = cdi.displayCustomerByAddress(customerAddress);
			System.out.println(c.getCustomerId()+" "+c.getCustomerName()+" "+c.getCustomerEmailId()+" "+c.getCustomerCity()+" "+c.getCustomerAddress()+" "+c.getCustomerContactNo());
			break;
			
		case 8:
			System.out.println("Enter Customer City");
			customerCity = sc.next();
			al = cdi.displayCustomerByCity(customerCity);
			for(Customer c1:al)
			{
				System.out.println(c1.getCustomerId()+" "+c1.getCustomerName()+" "+c1.getCustomerEmailId()+" "+c1.getCustomerCity()+" "+c1.getCustomerAddress()+" "+c1.getCustomerContactNo());

			}
			break;
			
		case 9:
			System.out.println("Enter Customer Email-Id:");
			customerEmailId = sc.next();
			
			c = cdi.displayCustomerByEmailId(customerEmailId);
			System.out.println(c.getCustomerId()+" "+c.getCustomerName()+" "+c.getCustomerEmailId()+" "+c.getCustomerCity()+" "+c.getCustomerAddress()+" "+c.getCustomerContactNo());
			break;
			
		case 10:
			System.out.println("Enter Customer Contact-No:");
			customerContactNo = sc.nextLong();
			
			c = cdi.displayCustomerByContactNo(customerContactNo);
			System.out.println(c.getCustomerId()+" "+c.getCustomerName()+" "+c.getCustomerEmailId()+" "+c.getCustomerCity()+" "+c.getCustomerAddress()+" "+c.getCustomerContactNo());
			break;
			
		case 11:
			System.out.println("Thank You!!!");
			break;
			
		default:
			System.out.println("Invalid Choice...");	
			
		}
		}while(choice<=10);
	}
}
