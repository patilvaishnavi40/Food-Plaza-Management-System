package com.foodplaza.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.foodplaza.daoimpl.OrdersDaoImpl;
import com.foodplaza.pojo.Orders;

public class OrdersMain 
{
	public static void main(String[] args) 
	{
		int choice;
		String customerEmailId, orderStatus;
		boolean flag;
		Scanner sc = new Scanner(System.in);
		List<Orders> al = new ArrayList<>();
		Orders o = new Orders();
		OrdersDaoImpl odi = new OrdersDaoImpl();
		
		do {
			System.out.println("1.Place Order\n2.Show All Orders\n3.Display Orders By Email-Id\n4.Cancel Order\n5.Check Order Status\n6.Update Order Status\n7.Exit\n\nEnter Your Choice:");
			choice = sc.nextInt();
			
			switch(choice)
			{
				case 1:
					System.out.println("Enter Your Email-Id:");
					customerEmailId = sc.next();
					
					flag = odi.placeOrder(customerEmailId);
					
					if(flag)
					{
						System.out.println("Order Placed Successfully!!\n");
					}
					
					else
					{
						System.out.println("Something Went Wrong!!\n");
					}
					break;
					
					
				case 2:
					al = odi.showOrders();
					for(Orders o1:al)
					{
						System.out.println("Order Id:"+o1.getOrderId()+"  Food Name:"+o1.getFoodName()+"  Customer Email-Id:"+o1.getCustomerEmailId()+"  Order Status:"+o1.getOrderStatus()+"  Order Date:"+o1.getOrderDate()+"  Total Bill:"+o1.getTotalBill()+"\n");
					}
					break;
					
					
				case 3:
					System.out.println("Enter Your Email-Id:");
					customerEmailId = sc.next();
					
					al = odi.showOrders(customerEmailId);
					for(Orders o1:al)
					{
						System.out.println("Order Id:"+o1.getOrderId()+"  Food Name:"+o1.getFoodName()+"  Customer Email-Id:"+o1.getCustomerEmailId()+"  Order Status:"+o1.getOrderStatus()+"  Order Date:"+o1.getOrderDate()+"  Total Bill:"+o1.getTotalBill()+"\n");
					}
					break;
					
					
				case 4:
					System.out.println("Enter Your Email-Id:");
					customerEmailId = sc.next();
					
					flag = odi.cancelOrder(customerEmailId);
					if(flag)
					{
						System.out.println("Order Cancelled Successfully!!");
					}
					
					else
					{
						System.out.println("Something Went Wrong!!");
					}
					break;
					
					
				case 5:
					System.out.println("Enter Your Email Id");
					customerEmailId=sc.next();
					o.setCustomerEmailId(customerEmailId);
					o = odi.checkStatus(customerEmailId);
					System.out.println(o.getOrderStatus());
					
					break;
				case 6:
					System.out.println("Enter Your Email Id ");
					customerEmailId=sc.next();
					System.out.println("Enter updated status ");
					orderStatus=sc.next();
					o.setCustomerEmailId(customerEmailId);
					o.setOrderStatus(orderStatus);
					flag= odi.updateOrderStatus(customerEmailId,orderStatus);
					if(flag)
					 {
						 System.out.println("Updated Successfully");
					 }
					 else
					 {
						 System.out.println("Unsuccessfully");
					 }
					break;
					
					
				case 7:
					System.out.println("Thank You!!");
					break;
			}
		}while(choice!=7);
	}
}
