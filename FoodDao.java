package com.foodplaza.dao;

import java.util.List;

import com.foodplaza.pojo.Food;

public interface FoodDao
{
	
	boolean addFood(Food f);
	
	boolean updateFood(Food f);
	
	boolean deleteFood(int foodId);
	
	List<Food> displayAllFood();
	
//	Food displayFoodById(int foodId);
//	
//	Food displayFoodByName(String foodName);
//	
	
	Food displayFood(int foodId);
	
	Food displayFood(String foodName);
	
	List<Food> displayFood(double foodPrice);
	
	List<Food> displayFoodByCategory(String foodCategory);
	
	List<Food> displayFoodByType(String foodType);
	
//	List<Food> displayFoodMaxMin(double foodPrice);
}