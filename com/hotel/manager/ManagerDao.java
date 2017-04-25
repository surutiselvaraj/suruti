package com.hotel.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hotel.ConnectionManager;
import com.hotel.RoomBean;

public class ManagerDao {
	public boolean managerloginvalidate(String loginid,String password)
	{
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
			ResultSet resultset = null;

		String searchQuery = "SELECT *  from T_XBBNHFQ_MANAGER where emailid=? and password=?";
		try {
			 stmt = conn.prepareStatement(searchQuery);
			stmt.setString(1, loginid);		
			stmt.setString(2, password);				
			 resultset = stmt.executeQuery();	
			while(resultset.next()) {
				return true;
						}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
		finally{
			try {
				if(resultset != null)
				resultset.close();
				if(stmt != null)					
				stmt.close();				
				conn.commit();
				if(conn != null)
				conn.close();
			}			
			 catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		return false;
	}
	public void updateRoomDetails(RoomBean rb)
	{
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		
		try{
		String str="update T_XBBNHFQ_Room set isac=?,noofcot=?,grade=?,livingspace=?,cost=?,type=? where hid=? and rid=?";
		stmt=conn.prepareStatement(str);
		stmt.setBoolean(1, rb.getIsAc());	
		stmt.setInt(2, rb.getNo_Of_cot());	
		stmt.setInt(3,rb.getGrade());	
		stmt.setInt(4, rb.getLivingSpace());	
		stmt.setInt(5, rb.getCost());
		stmt.setString(6, rb.getType());
		stmt.setInt(7, rb.getHid());
		stmt.setInt(8, rb.getRid());		
		stmt.execute();
		}
		catch(SQLException e)
		{
			System.out.print("updation errror");
		}
		finally{
			try {
				
				if(stmt != null)					
				stmt.close();				
				conn.commit();
				if(conn != null)
				conn.close();
			}			
			 catch (SQLException e) {
					
					e.printStackTrace();
				}
		}	
	}	
	
	
	public void insertRoom(RoomBean rb) {
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		Scanner sc=new Scanner(System.in);
		System.out.println("1.isAc  2.no. of cot 3.grade 4.living space 5.cost 6.Roomid 7.HotelID");
		
		try{
		//
			
			String str="INSERT INTO T_XBBNHFQ_ROOM VALUES(?,?,?,?,?,?,?,?)";
			
			stmt=conn.prepareStatement(str);
			stmt.setBoolean(1, rb.getIsAc());	
			stmt.setInt(2, rb.getNo_Of_cot());	
			stmt.setInt(3,rb.getGrade());	
			stmt.setInt(4, rb.getLivingSpace());	
			stmt.setInt(5, rb.getCost());
			stmt.setInt(6, rb.getRid());
			stmt.setInt(7, rb.getHid());
			stmt.setString(8, rb.getType());
			
		stmt.execute();
		}
		catch(SQLException e)
		{
			System.out.print("insertion errror");
		}
		finally{
			try {
				
				if(stmt != null)					
				stmt.close();				
				conn.commit();
				if(conn != null)
				conn.close();
			}			
			 catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
	}
	public  ManagerBean getManagerDetails(String emailid)
	{
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
	
		Scanner sc=new Scanner(System.in);
		ResultSet resultset = null;
		 ManagerBean managerbean= new ManagerBean();
		
			 String searchQuery = "SELECT *  from T_XBBNHFQ_MANAGER where emailid=?";
		try {
			 stmt = conn.prepareStatement(searchQuery);
			stmt.setString(1, emailid);		
				
			 resultset = stmt.executeQuery();	
			
			
			 
			while(resultset.next()) {
	
				managerbean.setManagerfname((resultset.getString(3)));
				managerbean.setManagerlname((resultset.getString(4)));
				managerbean.setAddress(resultset.getString(5));
				managerbean.setDistrict(resultset.getString(6));
				managerbean.setEmailid(resultset.getString(7));
				managerbean.setContactno(resultset.getLong(9));

	
						
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
		finally{
			try {
				if(resultset != null)
				resultset.close();
				if(stmt != null)					
				stmt.close();				
				conn.commit();
				if(conn != null)
				conn.close();
			}			
			 catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		return managerbean;	
	}
	
	public void updateProfile(String s1,String s2,Long s3,String emailid,String first){
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		List RoomList = null;



		String searchQuery = "update T_XBBNHFQ_MANAGER set address=?, district=?,contactno=? where emailid=? and managerfname = ?";

		try {
			 stmt = conn.prepareStatement(searchQuery);
			 stmt.setString(1,s1);
			 stmt.setString(2,s2);
			stmt.setLong(3, s3);	
			stmt.setString(4, emailid);	
			stmt.setString(5, first);
			stmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("exception in queery"+e);
		}

		finally{
			try {
				if(stmt != null)					
				stmt.close();				
				conn.commit();
				if(conn != null)
				conn.close();
			}			
			 catch (SQLException e) {
					
					e.printStackTrace();
				}
		}

		}

}
