package com.foodplaza.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodplaza.dao.FoodDao;
import com.foodplaza.pojo.Food;
import com.foodplaza.utility.DBUtility;

public class FoodDaoImpl implements FoodDao
{
	Connection conn;
	PreparedStatement ps;
	Statement st;
	ResultSet rs;
	String addFoodQuery,updateFoodQuery,deleteFoodQuery,displayAllFoodQuery,displayFoodByIdQuery,displayFoodByNameQuery,displayFoodByTypeQuery,displayFoodByCategoryQuery,displayFoodByPriceQuery,displayFoodMaxMinQuery;
	int row;
	List<Food> al = new ArrayList<>();
	Food f = new Food();
	
	@Override
	public boolean addFood(Food f) 
	{
		addFoodQuery="insert into Food(foodName,foodType,foodCategory,foodPrice)values(?,?,?,?)";
		
		try {
			conn = DBUtility.establishConnection();
			ps = conn.prepareStatement(addFoodQuery);
			
			ps.setString(1, f.getFoodName());
			ps.setString(2, f.getFoodType());
			ps.setString(3, f.getFoodCategory());
			ps.setDouble(4, f.getFoodPrice());
			
			int row = ps.executeUpdate();
			
			if(row>0)
			{
				return true;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateFood(Food f) 
	{
		updateFoodQuery = "update Food set foodName=?,foodType=?,foodCategory=?,foodPrice=? where foodId=?";
		
		try {
			conn = DBUtility.establishConnection();
			ps = conn.prepareStatement(updateFoodQuery);
			ps.setString(1, f.getFoodName());
			ps.setString(2, f.getFoodType());
			ps.setString(3, f.getFoodCategory());
			ps.setDouble(4, f.getFoodPrice());
			ps.setInt(5, f.getFoodId());

			row = ps.executeUpdate();
			
			if(row>0)
			{
				return true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return false;
	}

	@Override
	public boolean deleteFood(int foodInt) 
	{
		deleteFoodQuery = "delete from Food where foodId=?";
		
		try {
			conn = DBUtility.establishConnection();
			ps = conn.prepareStatement(deleteFoodQuery);
			ps.setInt(1, foodInt);
			
			row = ps.executeUpdate();
			if(row>0)
			{
				return true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;	
	}

	@Override
	public List<Food> displayAllFood() 
	{
		displayAllFoodQuery = "select * from Food";
		
		try {
			al.clear();
			conn = DBUtility.establishConnection();
			
			st = conn.createStatement();
			rs = st.executeQuery(displayAllFoodQuery);
			
			while(rs.next())
			{
				Food f = new Food();
				f.setFoodId(rs.getInt("foodId"));
				f.setFoodName(rs.getString("foodName"));
				f.setFoodType(rs.getString("foodType"));
				f.setFoodCategory(rs.getString("foodCategory"));
				f.setFoodPrice(rs.getDouble("foodPrice"));
				
				al.add(f);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return al;
	}

	@Override
	public Food displayFood(int foodId)
	{
		displayFoodByIdQuery = "select * from Food where foodId=?";
		
		try {
			conn = DBUtility.establishConnection();
			
			ps = conn.prepareStatement(displayFoodByIdQuery);
			ps.setInt(1, foodId);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				f.setFoodId(rs.getInt("foodId"));
				f.setFoodName(rs.getString("foodName"));
				f.setFoodType(rs.getString("foodType"));
				f.setFoodCategory(rs.getString("foodCategory"));
				f.setFoodPrice(rs.getDouble("foodPrice"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}

	@Override
	public Food displayFood(String foodName) 
	{
		displayFoodByNameQuery = "select * from Food where foodName=?";
		
		try {
			conn = DBUtility.establishConnection();
			
			ps = conn.prepareStatement(displayFoodByNameQuery);
			ps.setString(1, foodName);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				f.setFoodId(rs.getInt("foodId"));
				f.setFoodName(rs.getString("foodName"));
				f.setFoodType(rs.getString("foodType"));
				f.setFoodCategory(rs.getString("foodCategory"));
				f.setFoodPrice(rs.getDouble("foodPrice")); 
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}

	@Override
	public List<Food> displayFood(double foodPrice)
	{
		displayFoodByPriceQuery = "select * from Food where foodPrice =?";
		
		try {
			al.clear();
			conn = DBUtility.establishConnection();
			
			ps = conn.prepareStatement(displayFoodByPriceQuery);
			ps.setDouble(1, foodPrice);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				Food f = new Food();
				f.setFoodId(rs.getInt("foodId"));
				f.setFoodName(rs.getString("foodName"));
				f.setFoodType(rs.getString("foodType"));
				f.setFoodCategory(rs.getString("foodCategory"));
				f.setFoodPrice(rs.getDouble("foodPrice"));
				
				al.add(f);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}

	@Override
	public List<Food> displayFoodByType(String foodType)
	{
		al.clear();
		displayFoodByTypeQuery = "select * from Food where foodType=?";
		
		try {
			al.clear();
			conn = DBUtility.establishConnection();
			
			ps = conn.prepareStatement(displayFoodByTypeQuery);
			ps.setString(1,foodType);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				Food f = new Food();
				f.setFoodId(rs.getInt("foodId"));
				f.setFoodName(rs.getString("foodName"));
				f.setFoodType(rs.getString("foodType"));
				f.setFoodCategory(rs.getString("foodCategory"));
				f.setFoodPrice(rs.getDouble("foodPrice"));
				
				al.add(f);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return al;
	}
	
	public List<Food> displayFoodByCategory(String foodCategory)
	{
		displayFoodByCategoryQuery = "select * from Food where foodCategory=?";
		
		try {
			al.clear();
			conn = DBUtility.establishConnection();
			ps = conn.prepareStatement(displayFoodByCategoryQuery);
			ps.setString(1, foodCategory);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Food f = new Food();
				f.setFoodId(rs.getInt("foodId"));
				f.setFoodName(rs.getString("foodName"));
				f.setFoodType(rs.getString("foodType"));
				f.setFoodCategory(rs.getString("foodCategory"));
				f.setFoodPrice(rs.getDouble("foodPrice"));
				
				al.add(f);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return al;
	}

//	@Override
//	public List<Food> displayFoodMaxMin(double foodPrice) {
//		displayFoodMaxMinQuery = "select * from Food where max=? and min=?";
//		
//		try {
//			al.clear();
//			conn = DBUtility.establishConnection();
//			ps = conn.prepareStatement(displayFoodMaxMinQuery);
//			ps.setDouble(1, Maximum);
//			rs = ps.executeQuery();
//			
//			while(rs.next())
//			{
//				Food f = new Food();
//				f.setFoodName(rs.getString("foodName"));
//				f.setFoodType(rs.getString("foodType"));
//				f.setFoodCategory(rs.getString("foodCategory"));
//				f.setFoodPrice(rs.getDouble("foodPrice"));
//				
//				al.add(f);
//			}
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return al;
//	}
}
