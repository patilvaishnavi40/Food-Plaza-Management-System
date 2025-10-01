package com.foodplaza.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodplaza.dao.CustomerDao;
import com.foodplaza.pojo.Customer;
import com.foodplaza.pojo.Food;
import com.foodplaza.utility.DBUtility;

public class CustomerDaoImpl implements CustomerDao
{
	Connection conn;
	PreparedStatement ps;
	Statement st;
	ResultSet rs;
	String addCustomerQuery,updateCustomerQuery,deleteCustomerQuery,displayAllCustomerQuery,displayCustomerByIdQuery,displayCustomerByNameQuery,displayCustomerByAddressQuery,displayCustomerByContactNoQuery,displayCustomerByEmailIdQuery,displayCustomerByCityQuery;
	int row;
	List<Customer> al = new ArrayList<>();
	Customer c = new Customer();
	
	@Override
	public boolean addCustomer(Customer c)
	{
		addCustomerQuery="insert into Customer(customerName,customerEmailId,customerAddress,customerCity,customerContactNo)values(?,?,?,?,?)";
		
		try {
			conn = DBUtility.establishConnection();
			ps = conn.prepareStatement(addCustomerQuery);
			
			ps.setString(1, c.getCustomerName());
			ps.setString(2, c.getCustomerEmailId());
			ps.setString(3, c.getCustomerAddress());
			ps.setString(4, c.getCustomerCity());
			ps.setLong(5, c.getCustomerContactNo());
			
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
	public boolean updateCustomer(Customer c) 
	{
		updateCustomerQuery ="update Customer set customerName=?,customerEmailId=?,customerAddress=?,customerCity=?,customerContactNo=? where customerId=?";
		
		try {
			conn = DBUtility.establishConnection();
			ps = conn.prepareStatement(updateCustomerQuery);
			
			ps.setString(1, c.getCustomerName());
			ps.setString(2, c.getCustomerEmailId());
			ps.setString(3, c.getCustomerAddress());
			ps.setString(4, c.getCustomerCity());
			ps.setLong(5, c.getCustomerContactNo());
			ps.setInt(6, c.getCustomerId());
			
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
	public boolean deleteCustomer(int customerId) 
	{
		deleteCustomerQuery = "delete from Customer where customerId=?";
		 try {
			conn = DBUtility.establishConnection();
			ps = conn.prepareStatement(deleteCustomerQuery);
			
			ps.setInt(1, customerId);
			
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
	public List<Customer> displayAllCustomer() 
	{
		displayAllCustomerQuery = "select * from Customer";
		
		try {
			al.clear();
			conn = DBUtility.establishConnection();
			
			st = conn.createStatement();
			rs = st.executeQuery(displayAllCustomerQuery);
			
			while(rs.next())
			{
				Customer c = new Customer();
				c.setCustomerId(rs.getInt("customerId"));
				c.setCustomerName(rs.getString("customerName"));
				c.setCustomerEmailId(rs.getString("customerEmailId"));
				c.setCustomerCity(rs.getString("customerCity"));
				c.setCustomerAddress(rs.getString("customerAddress"));
				c.setCustomerContactNo(rs.getLong("customerContactNo"));
				
				al.add(c);
			}
						
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return al;
	}

	@Override
	public Customer displayCustomerById(int customerId) 
	{
		displayCustomerByIdQuery = "select * from Customer where customerId=?";
		
		try {
			conn = DBUtility.establishConnection();
			
			ps = conn.prepareStatement(displayCustomerByIdQuery);
			ps.setInt(1, customerId);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				c.setCustomerName(rs.getString("customerName"));
				c.setCustomerEmailId(rs.getString("customerEmailId"));
				c.setCustomerCity(rs.getString("customerCity"));
				c.setCustomerAddress(rs.getNString("customerAddress"));
				c.setCustomerContactNo(rs.getLong("customerContactNo"));
				c.setCustomerId(rs.getInt("customerId"));
				
			}
		}
			catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<Customer> displayCustomerByName(String customerName) 
	{
		displayCustomerByNameQuery = "select * from Customer where customerName =?";
		
		try {
			al.clear();
			conn = DBUtility.establishConnection();
			
			ps = conn.prepareStatement(displayCustomerByNameQuery);
			ps.setString(1, customerName);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				Customer c = new Customer();
				c.setCustomerId(rs.getInt("customerId"));
				c.setCustomerName(rs.getString("customerName"));
				c.setCustomerEmailId(rs.getString("customerEmailId"));
				c.setCustomerCity(rs.getString("customerCity"));
				c.setCustomerAddress(rs.getString("customerAddress"));
				c.setCustomerContactNo(rs.getLong("customerContactNo"));

				al.add(c);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}

	@Override
	public Customer displayCustomerByAddress(String customerAddress) 
	{
		displayCustomerByAddressQuery = "select * from Customer where customerAddress=?";
		try {
			conn = DBUtility.establishConnection();
			ps=conn.prepareStatement(displayCustomerByAddressQuery);
			ps.setString(1, customerAddress);
			
			rs=ps.executeQuery();
			while(rs.next())
			{
				c.setCustomerId(rs.getInt("customerId"));
				c.setCustomerName(rs.getString("customerName"));
				c.setCustomerEmailId(rs.getString("customerEmailId"));
				c.setCustomerCity(rs.getString("customerCity"));
				c.setCustomerAddress(rs.getString("customerAddress"));
				c.setCustomerContactNo(rs.getLong("customerContactNo"));
			} 
		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}

	@Override
	public Customer displayCustomerByContactNo(Long customerContactNo) 
	{
		displayCustomerByContactNoQuery = "select * from Customer where customerContactNo=?";
		try {
			conn = DBUtility.establishConnection();
			ps=conn.prepareStatement(displayCustomerByContactNoQuery);
			ps.setLong(1, customerContactNo);
			
			rs=ps.executeQuery();
			while(rs.next())
			{
				c.setCustomerId(rs.getInt("customerId"));
				c.setCustomerName(rs.getString("customerName"));
				c.setCustomerEmailId(rs.getString("customerEmailId"));
				c.setCustomerCity(rs.getString("customerCity"));
				c.setCustomerAddress(rs.getString("customerAddress"));
				c.setCustomerContactNo(rs.getLong("customerContactNo"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	@Override
	public Customer displayCustomerByEmailId(String customerEmailId) {
		displayCustomerByEmailIdQuery = "select * from Customer where customerEmailId=?";
		try {
			conn = DBUtility.establishConnection();
			ps=conn.prepareStatement(displayCustomerByEmailIdQuery);
			ps.setString(1, customerEmailId);
			
			rs=ps.executeQuery();
			while(rs.next())
			{
				c.setCustomerId(rs.getInt("customerId"));
				c.setCustomerName(rs.getString("customerName"));
				c.setCustomerEmailId(rs.getString("customerEmailId"));
				c.setCustomerCity(rs.getString("customerCity"));
				c.setCustomerAddress(rs.getString("customerAddress"));
				c.setCustomerContactNo(rs.getLong("customerContactNo"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;		
	}

	@Override
	public List<Customer> displayCustomerByCity(String customerCity) {
		displayCustomerByCityQuery = "select * from Customer where customerCity=?";
		
		try {
			al.clear();
			conn = DBUtility.establishConnection();
			
			ps = conn.prepareStatement(displayCustomerByCityQuery);
			ps.setString(1, customerCity);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				Customer c = new Customer();
				c.setCustomerId(rs.getInt("customerId"));
				c.setCustomerName(rs.getString("customerName"));
				c.setCustomerEmailId(rs.getString("customerEmailId"));
				c.setCustomerCity(rs.getString("customerCity"));
				c.setCustomerAddress(rs.getString("customerAddress"));
				c.setCustomerContactNo(rs.getLong("customerContactNo"));

				al.add(c);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}
}
