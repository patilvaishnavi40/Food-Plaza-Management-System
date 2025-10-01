package com.foodplaza.daoimpl;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.foodplaza.dao.OrdersDao;
import com.foodplaza.pojo.Cart;
import com.foodplaza.pojo.Orders;
import com.foodplaza.utility.DBUtility;

public class OrdersDaoImpl implements OrdersDao{
	
	
	String foodName,foodNameFromCartQuery,totalBillQuery,placeOrderQuery,showOrdersQuery,showOrderQuery1,cancelOrderQuery,checkStatusQuery,updateStatusQuery;
	String orderDate = new Date().toString();
	double totalBill;
	int row;
	Connection conn;
	Statement st;
	PreparedStatement ps;
	ResultSet rs;
	Orders o;
	List<Orders> al = new ArrayList<>();
	
	@Override
	public boolean placeOrder(String customerEmailId) 
	{
		String orderDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		foodNameFromCartQuery = "select foodName from Cart where customerEmailId=?";
		
		//totalBillQuery = "select foodPrice*foodQty from Cart where customerEmailId =?";
		//totalBillQuery = "select foodPrice*foodQty as totalBill from Cart where customerEmailId=?";
		
		totalBillQuery = "select sum(foodPrice*foodQty)as totalBill from Cart where customerEmailId=?";
		
		placeOrderQuery = "insert into Orders(foodName,customerEmailId,orderStatus,orderDate,totalBill)values(?,?,?,?,?)";
		
		try {
			conn = DBUtility.establishConnection();
			
			ps = conn.prepareStatement(foodNameFromCartQuery);
			ps.setString(1, customerEmailId);
			
			rs = ps.executeQuery();
			while(rs.next())
			{
				foodName = rs.getString("foodName");
			}
			
			ps = conn.prepareStatement(totalBillQuery);
			ps.setString(1, customerEmailId);
			
			rs = ps.executeQuery();
			while(rs.next())
			{
				totalBill = rs.getDouble("totalBill");
			}
			
			ps = conn.prepareStatement(placeOrderQuery);
			ps.setString(1, foodName);
			ps.setString(2, customerEmailId);
			ps.setString(3, "Pending");
			ps.setString(4, orderDate); // now in correct MySQL format
			ps.setDouble(5, totalBill);
			
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
	public List<Orders> showOrders() 
	{
		showOrdersQuery = "select * from Orders";
		
		try {
			al.clear();
			conn = DBUtility.establishConnection();
			
			st = conn.createStatement();
			rs = st.executeQuery(showOrdersQuery);
			
			while(rs.next()) 
			{
				Orders o = new Orders();
				o.setOrderId(rs.getInt("orderId"));
				o.setFoodName(rs.getString("foodName"));
				o.setCustomerEmailId(rs.getString("customerEmailId"));
				o.setOrderStatus(rs.getString("orderStatus"));
				o.setOrderDate(rs.getString("orderdate"));
				o.setTotalBill(rs.getDouble("totalBill"));
				
				al.add(o);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}

	@Override
	public List<Orders> showOrders(String customerEmailId)
	{
		showOrderQuery1 = "select * from Orders where customerEmailId =?";
		
		try {
			al.clear();
			conn = DBUtility.establishConnection();
			
			ps = conn.prepareStatement(showOrderQuery1);
			ps.setString(1, customerEmailId);
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Orders o = new Orders();
				o.setOrderId(rs.getInt("orderId"));
				o.setFoodName(rs.getString("foodName"));
				o.setCustomerEmailId(rs.getString("customerEmailId"));
				o.setOrderStatus(rs.getString("orderStatus"));
				o.setOrderDate(rs.getString("orderdate"));
				o.setTotalBill(rs.getDouble("totalBill"));
				
				al.add(o);

			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return al;
	}

	@Override
	public boolean cancelOrder(String customerEmailId)
	{
		cancelOrderQuery = "delete from Orders where customerEmailId = ?";
		
		try {
			conn = DBUtility.establishConnection();
			
			ps = conn.prepareStatement(cancelOrderQuery);
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
	public Orders checkStatus(String customerEmailId) {
		checkStatusQuery="select * from orders where customerEmailId = ?";
		try {
			//Orders o = new Orders();
			conn =DBUtility.establishConnection();
			ps=conn.prepareStatement(checkStatusQuery);
			ps.setString(1, customerEmailId);
			rs=ps.executeQuery();
			while(rs.next())
            {
            	o.setOrderStatus(rs.getString("orderStatus"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		return o;
	}

	@Override
	public boolean updateOrderStatus(String customerEmailId, String orderStatus) {
		updateStatusQuery = "update orders set orderStatus=? where customerEmailId=?";
		
		try {
			conn = DBUtility.establishConnection();
			ps = conn.prepareStatement(updateStatusQuery);
			ps.setString(1, orderStatus);
			ps.setString(2, customerEmailId);
			
			row=ps.executeUpdate();
			 while(row>0)
			 {
				 return true;
			 }	
				
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
