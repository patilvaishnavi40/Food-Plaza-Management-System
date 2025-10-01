package com.foodplaza.dao;

import java.util.List;

import com.foodplaza.pojo.Orders;

public interface OrdersDao 
{
	boolean placeOrder(String customerEmailId);
	
	List<Orders> showOrders();
	
	List<Orders> showOrders(String customerEmailId);
	
	boolean cancelOrder(String customerEmailId);
	
	Orders checkStatus(String customerEmailId);
	
	boolean updateOrderStatus(String customerEmailId,String orderStatus);
	
}	
