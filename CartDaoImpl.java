package com.foodplaza.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.foodplaza.dao.CartDao;
import com.foodplaza.pojo.Cart;
import com.foodplaza.pojo.Food;
import com.foodplaza.utility.DBUtility;
import com.foodplaza.pojo.Cart;
import com.foodplaza.pojo.Customer;

public class CartDaoImpl implements CartDao
{
	String insertCartQuery,deleteCartQuery,deleteCartQuery1,showCartQuery,showCart;
	Connection conn;
	Statement st;
	ResultSet rs;
	PreparedStatement ps;
	FoodDaoImpl fdi = new FoodDaoImpl();
	List<Cart> al = new ArrayList<>();
	int row;
	
	@Override
	public boolean addToCart(Cart ct) 
	{
		insertCartQuery = "insert into Cart(foodId,foodName,foodQty,customerEmailId,foodPrice) values(?,?,?,?,?)";
		
		try {
			conn = DBUtility.establishConnection();
			ps = conn.prepareStatement(insertCartQuery);
			
			Food f = fdi.displayFood(ct.getFoodName());
			if(f!=null)
			{
				ps.setInt(1, f.getFoodId());
				ps.setString(2, f.getFoodName());
				ps.setInt(3,ct.getFoodQty());
				ps.setString(4, ct.getCustomerEmailId());
				ps.setDouble(5, f.getFoodPrice());

				row = ps.executeUpdate();
				
				if(row>0)
				{
					return true;
				}
				
				else
				{
					System.out.println("Food Not Found!!");
					return false;
				}
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCart(int cartId) 
	{
		deleteCartQuery = "delete from Cart where cartId=?";
		
		try {
			conn = DBUtility.establishConnection();
			ps = conn.prepareStatement(deleteCartQuery);
			ps.setInt(1, cartId);
			
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
	public boolean deleteCart(String customerEmailId) 
	{
		deleteCartQuery1 = "delete from Cart where customerEmailId = ?";
		
		try {
			conn = DBUtility.establishConnection();
			ps = conn.prepareStatement(deleteCartQuery1);
			ps.setString(1, customerEmailId);
			
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
	public List<Cart> showCart() 
	{
		showCartQuery = "select * from Cart";
		
		try {
			al.clear();
			conn = DBUtility.establishConnection();
			
			st = conn.createStatement();
			rs = st.executeQuery(showCartQuery);
			
			while(rs.next())
			{
				Cart ct = new Cart();
				ct.setCartId(rs.getInt("cartId"));
				ct.setFoodId(rs.getInt("foodId"));
				ct.setFoodName(rs.getString("foodName"));
				ct.setFoodQty(rs.getInt("foodQty"));
				ct.setCustomerEmailId(rs.getString("customerEmailId"));
				ct.setFoodPrice(rs.getDouble("foodPrice"));
				
				al.add(ct);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return al;
	}

	@Override
	public List<Cart> showCart(String customerEmailId) 
	{
		showCart = "select * from Cart where customerEmailId =?";
		
		try {
			al.clear();
			conn = DBUtility.establishConnection();
			
			ps = conn.prepareStatement(showCart);
			ps .setString(1, customerEmailId);
			
			rs = ps.executeQuery();
			
			while (rs.next())
			{
				Cart ct = new Cart();
				ct.setCartId(rs.getInt("cartId"));
				ct.setFoodId(rs.getInt("foodId"));
				ct.setFoodName(rs.getString("foodName"));
				ct.setFoodQty(rs.getInt("foodQty"));
				ct.setCustomerEmailId(rs.getString("customerEmailId"));
				ct.setFoodPrice(rs.getDouble("foodPrice"));

				al.add(ct);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}
	
}