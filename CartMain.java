package com.foodplaza.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.foodplaza.daoimpl.CartDaoImpl;
import com.foodplaza.daoimpl.CustomerDaoImpl;
import com.foodplaza.daoimpl.FoodDaoImpl;
import com.foodplaza.pojo.Cart;
import com.foodplaza.pojo.Customer;
import com.foodplaza.pojo.Food;

public class CartMain
{
	public static void main(String[] args) 
	{
		int choice,foodQty,cartId;
		String customerEmailId,foodName;
		boolean flag;
		Scanner sc = new Scanner(System.in);
		CustomerDaoImpl cdi = new CustomerDaoImpl();
		FoodDaoImpl fdi = new FoodDaoImpl();
		Cart ct = new Cart();
		CartDaoImpl ctdi = new CartDaoImpl();
		List<Cart> al = new ArrayList<>();
		
		do {
		System.out.println("1.Add To Cart\n2.Delete Cart\n3.Delete Cart By Email-Id\n4.Display All Cart Details\n5.Display Cart By Email-Id\n6.Exit\n\nEnter Your Choice:");
		choice = sc.nextInt();
		
		switch(choice)
		{
			case 1:
				System.out.println("Enter Your Email-Id:");
				customerEmailId = sc.next();
				
				Customer c = cdi.displayCustomerByEmailId(customerEmailId);
				
				if(c==null)
				{
					System.out.println("Email-Id not Registered...Kindly Register First!!");
				}
				
				else
				{
					System.out.println("Enter Food Name:");
					foodName = sc.next();
					
					Food f = fdi.displayFood(foodName);
					if(f!=null)
					{
						System.out.println("Food Found: "+f.getFoodName()+"\n");
						System.out.println("Enter Food Quantity:");
						foodQty = sc.nextInt();
				
						ct.setCustomerEmailId(customerEmailId);
						ct.setFoodName(f.getFoodName());
						ct.setFoodQty(foodQty);
						ct.setFoodId(f.getFoodId());
						
						flag = ctdi.addToCart(ct);
						if(flag)
						{
							System.out.println("Food Added To Cart!!\n");
						}
						
						else
						{
							System.out.println("Adding To Cart Failed!!\n");
						}
					}
					
					else
					{
						System.out.println("Sold Out...We are Working on it...");
					}
				}
				break;
				
			case 2:
				System.out.println("Enter Your Cart-Id:");
				cartId = sc.nextInt();
				
				flag = ctdi.deleteCart(cartId);
				
				if(flag)
				{
					System.out.println("Cart Deleted Successfully!!\n");
				}
				
				else
				{
					System.out.println("Cart Deletion failed!!\n");
				}
				break;
				
			case 3:
				System.out.println("Enter Your Email-Id:");
				customerEmailId = sc.next();
				
				flag = ctdi.deleteCart(customerEmailId);
				
				if(flag)
				{
					System.out.println("Cart deleted Successfully!!\n");
				}
				
				else
				{
					System.out.println("Cart Deletion Failed!!\n");
				}
				break;
				
			case 4:
				al = ctdi.showCart();
				for(Cart ct1:al)
				{
				System.out.println("Cart Id:"+ct1.getCartId()+"  Food Id:"+ct1.getFoodId()+"  Food Name:"+ct1.getFoodName()+"  Food Quantity:"+ct1.getFoodQty()+"  Customer Email-Id:"+ct1.getCustomerEmailId()+"  Food Price:"+ct1.getFoodPrice()+"\n");
				}
				break;
				
			case 5:
				System.out.println("Enter Your Email-Id:");
				customerEmailId = sc.next();
				
				al = ctdi.showCart(customerEmailId);
				
				for(Cart ct1 : al)
				{
					System.out.println("Cart Id:"+ct1.getCartId()+"  Food Id:"+ct1.getFoodId()+"  Food Name:"+ct1.getFoodName()+"  Food Quantity:"+ct1.getFoodQty()+"  Customer Email-Id:"+ct1.getCustomerEmailId()+"  Food Price:"+ct1.getFoodPrice()+"\n");
				}
				break;
				
			case 6:
				System.out.println("Thank You!!!");		
				break;
				
			default:
				System.out.println("Invalid Choice...");
		}
	}while(choice!=6);
	}
}