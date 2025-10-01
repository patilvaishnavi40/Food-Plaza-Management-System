package com.foodplaza.pojo;

public class Orders 
{
	private int orderId;
	private String foodName,customerEmailId,orderStatus,orderDate;
	private double totalBill;
	
	public int getOrderId()
	{
		return orderId;
	}
	
	public void setOrderId(int orderId) 
	{
		this.orderId = orderId;
	}
	
	public String getFoodName() 
	{
		return foodName;
	}
	
	public void setFoodName(String foodName) 
	{
		this.foodName = foodName;
	}
	
	public String getCustomerEmailId()
	{
		return customerEmailId;
	}
	
	public void setCustomerEmailId(String customerEmailId) 
	{
		this.customerEmailId = customerEmailId;
	}
	
	public String getOrderStatus() 
	{
		return orderStatus;
	}
	
	public void setOrderStatus(String orderStatus) 
	{
		this.orderStatus = orderStatus;
	}
	
	public String getOrderDate() 
	{
		return orderDate;
	}
	
	public void setOrderDate(String orderDate)
	{
		this.orderDate = orderDate;
	}
	
	public double getTotalBill() 
	{
		return totalBill;
	}
	
	public void setTotalBill(double totalBill) 
	{
		this.totalBill = totalBill;
	}
	
	
}
