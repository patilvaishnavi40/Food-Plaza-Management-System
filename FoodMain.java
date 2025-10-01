package com.foodplaza.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.foodplaza.daoimpl.FoodDaoImpl;
import com.foodplaza.pojo.Food;

public class FoodMain 
{

	public static void main(String[] args) 
	{
		int choice;
		boolean flag;
		Scanner sc = new Scanner(System.in);
		FoodDaoImpl fdi = new FoodDaoImpl();
		Food f = new Food();
		List<Food> al = new ArrayList<>();
		String foodName,foodType,foodCategory;
		double foodPrice;
		int foodId;
		
		do 
		{
			System.out.println("1.Add Food\n2.Update Food\n3.Delete Food\n4.Display All Food\n5.Display Food By Id\n6.Display Food By Name\n7.Display Food By Type\n8.Display Food By Category\n9.Display Food By Price\n10.Exit\n\nEnter Your Choice: ");
			choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.println("Enter Food Name:");
				foodName = sc.next();
				
				System.out.println("Enter Food Type:");
				foodType = sc.next();
				
				System.out.println("Enter Food Category:");
				foodCategory = sc.next();
				
				System.out.println("Enter Food Price:");
				foodPrice = sc.nextDouble();
				
				f.setFoodName(foodName);
				f.setFoodType(foodType);
				f.setFoodCategory(foodCategory);
				f.setFoodPrice(foodPrice);
				
				flag = fdi.addFood(f);
				
				if(flag)
				{
					System.out.println("Food Added Successfully!!\n");
				}
				
				else
				{
					System.out.println("Food Adding Failed\n");
				}
				
				break;
				
			case 2:
				System.out.println("Enter Food Id:");
				foodId = sc.nextInt();
				
				System.out.println("Enter Food Name:");
				foodName = sc.next();
				
				System.out.println("Enter Food Type:");
				foodType = sc.next();
				
				System.out.println("Enter Food Category:");
				foodCategory = sc.next();
				
				System.out.println("Enter Food Price:");
				foodPrice = sc.nextDouble();
				
				f.setFoodId(foodId);
				f.setFoodName(foodName);
				f.setFoodType(foodType);
				f.setFoodCategory(foodCategory);
				f.setFoodPrice(foodPrice);
				
				flag = fdi.updateFood(f);
				if(flag)
				{
					System.out.println("Food Updated Successfully!!!\n");
				}
				
				else
				{
					System.out.println("Food Updation Failed!!!\n");
				}
				break;
				
			case 3:
				System.out.println("Enter Food Id:");
				foodId = sc.nextInt();
				
				flag = fdi.deleteFood(foodId);
				
				if(flag)
				{
					System.out.println("Food Deleted Successfully!!!\n");
				}
				
				else
				{
					System.out.println("Food Deletion Failed!!!");
				}
				break;
				
			case 4:
				al = fdi.displayAllFood();
				for(Food f1:al)
				{
				System.out.println(f1.getFoodId()+" "+f1.getFoodName()+" "+f1.getFoodType()+" "+f1.getFoodCategory()+" "+f1.getFoodPrice()+"\n");
				}
				break;
				
			case 5:
				System.out.println("Enter Food Id:");
				foodId = sc.nextInt();
				
				f = fdi.displayFood(foodId);
				 System.out.println(f.getFoodId()+" "+f.getFoodName()+" "+f.getFoodType()+" "+f.getFoodCategory()+" "+f.getFoodPrice()+"\n");
				break;
				
			case 6:
				System.out.println("Enter Food Name:");
				foodName = sc.next();
				
				f = fdi.displayFood(foodName);
				System.out.println(f.getFoodId()+" "+f.getFoodName()+" "+f.getFoodType()+" "+f.getFoodCategory()+" "+f.getFoodPrice()+"\n");
				break;
				
			case 7:
				System.out.println("Enter The Food Type:");
				foodType = sc.next();
				
				al = fdi.displayFoodByType(foodType);
				for(Food f1:al)
				{
				System.out.println(f1.getFoodId()+" "+f1.getFoodName()+" "+f1.getFoodType()+" "+f1.getFoodCategory()+" "+f1.getFoodPrice()+"\n");
				}
				break;
				
			case 8:
				System.out.println("Enter The Food Category:");
				foodCategory = sc.next();
				
				al = fdi.displayFoodByCategory(foodCategory);
				for(Food f1:al)
				{
				System.out.println(f1.getFoodId()+" "+f1.getFoodName()+" "+f1.getFoodType()+" "+f1.getFoodCategory()+" "+f1.getFoodPrice()+"\n");
				}
				break;
				
			case 9:
				System.out.println("Enter The Food Price:");
				foodPrice = sc.nextDouble();
				
				al = fdi.displayFood(foodPrice);
				for(Food f1:al)
				{
				System.out.println(f1.getFoodId()+" "+f1.getFoodName()+" "+f1.getFoodType()+" "+f1.getFoodCategory()+" "+f1.getFoodPrice()+"\n");
				}
				break;
				
			case 10:
				System.out.println("Thank You!!");
				break;
				
				default:
					System.out.println("Invalid Choice");
			}
		}
		while(choice!=9);
	}
}
