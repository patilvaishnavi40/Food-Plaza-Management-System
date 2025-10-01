package com.foodplaza.pojo;

public class Customer 
{
	private int customerId;
	private String customerName,customerCity,customerAddress,customerEmailId;
	Long customerContactNo;
	
	public Long getCustomerContactNo() 
	{
		return customerContactNo;
	}

	public void setCustomerContactNo(Long customerContactNo) 
	{
		this.customerContactNo = customerContactNo;
	}

	public String getCustomerCity() 
	{
		return customerCity;
	}

	public void setCustomerCity(String customerCity) 
	{
		this.customerCity = customerCity;
	}

	public String getCustomerAddress() 
	{
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) 
	{
		this.customerAddress = customerAddress;
	}

	public String getCustomerEmailId() {
		return customerEmailId;
	}

	public void setCustomerEmailId(String customerEmailId)
	{
		this.customerEmailId = customerEmailId;
	}
	
	public int getCustomerId()
	{
		return customerId;
	}
	
	public void setCustomerId(int customerId)
	{
		this.customerId = customerId;
	}
	
	public String getCustomerName()
	{
		return customerName;
	}
	
	public void setCustomerName(String customerName) 
	{
		this.customerName = customerName;
	}

	
	
}
