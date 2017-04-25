package com.hotel.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hotel.BookingBean;
import com.hotel.ConnectionManager;
import com.hotel.HotelBean;
import com.hotel.RoomBean;
import com.hotel.manager.ManagerBean;

public class AdminDao {
	
	
	public List viewBookings() 
	{
	
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = null;
			List BookedList = null;
			ResultSet resultset = null;
			
			
				 String searchQuery = "SELECT *  from T_XBBNHFQ_Bookings b join T_XBBNHFQ_Hotel h on b.hid=h.hid  order by h.name";
			try {
				 stmt = conn.prepareStatement(searchQuery);
					
				 resultset = stmt.executeQuery();	
				
				 BookedList = new ArrayList<BookingBean>();
				while(resultset.next()) {
					HotelBean hbean=new HotelBean();
					hbean.hotelname=resultset.getString(7);
					hbean.location=resultset.getString(9);
					RoomBean rbean=new RoomBean();
					rbean.rid=resultset.getInt(2);
					BookingBean bookBean = new BookingBean();
					bookBean.setHid(resultset.getInt(1));
					bookBean.setFromdate(""+resultset.getDate(3));
					bookBean.setTodate(""+resultset.getDate(4));
					bookBean.setLoginid(resultset.getString(5));
					bookBean.setHbean(hbean);
					bookBean.setRbean(rbean);
					BookedList.add(bookBean);
					
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
			
			return BookedList;
			
		}
	
	
	public List BookingDetails(){
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		List BookedList = null;
		ResultSet resultset = null;
		
		
			 String searchQuery = "SELECT *  from T_XBBNHFQ_Bookings b join T_XBBNHFQ_Hotel h on b.hid=h.hid ";
		try {
			 stmt = conn.prepareStatement(searchQuery);
				
			 resultset = stmt.executeQuery();	
			
			 BookedList = new ArrayList<BookingBean>();
			while(resultset.next()) {
				HotelBean hbean=new HotelBean();
				hbean.hotelname=resultset.getString(7);
				hbean.location=resultset.getString(9);
				RoomBean rbean=new RoomBean();
				rbean.rid=resultset.getInt(2);
				BookingBean bookBean = new BookingBean();
				bookBean.setHid(resultset.getInt(1));
				bookBean.setFromdate(""+resultset.getDate(3));
				bookBean.setTodate(""+resultset.getDate(4));
				bookBean.setLoginid(resultset.getString(5));
				bookBean.setHbean(hbean);
				bookBean.setRbean(rbean);
				BookedList.add(bookBean);
						
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
		
		return BookedList;
		
	}


	public ArrayList viewManagerDetails() 
	{
	
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = null;
			ArrayList<ManagerBean> mist = new ArrayList();
			ResultSet resultset = null;
			
			
				 String searchQuery = "SELECT *  from T_XBBNHFQ_Manager b join T_XBBNHFQ_Hotel h on b.hid=h.hid";
			try {
				 stmt = conn.prepareStatement(searchQuery);
					
				 resultset = stmt.executeQuery();	
				
			
				while(resultset.next()) {
					ManagerBean mbean=new ManagerBean();
					HotelBean hbean =new HotelBean();
					hbean.setHotelname(resultset.getString(11));
					hbean.setLocation(resultset.getString(13));
					hbean.setAddress(resultset.getString(12));
					hbean.setHid(resultset.getInt(10));
					hbean.setLevel(resultset.getInt(14));
					hbean.setRating(resultset.getInt(14));
					mbean.setHid(resultset.getInt(2));
					mbean.setManagerid(resultset.getInt(1));
					mbean.setManagerfname(resultset.getString(3));
					mbean.setManagerlname(resultset.getString(4));
					mbean.setAddress(resultset.getString(5));
					mbean.setDistrict(resultset.getString(6));
					mbean.setEmailid(resultset.getString(7));
					mbean.setContactno(resultset.getLong(9));
					mbean.setPassword(resultset.getString(8));
					mbean.setHbean(hbean);
					System.out.println(mbean.getHbean().getAddress());
				mist.add(mbean);
							System.out.println(""+resultset.getString(11)+"locat"+resultset.getString(13)+resultset.getString(3)+resultset.getString(4));
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
			
			return mist;
			
		}

	public ArrayList viewHotelDetails() 
	{
	
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = null;

			ResultSet resultset = null;
			 ArrayList<HotelBean> HotelList = new ArrayList<HotelBean>();		
			
				 String searchQuery = "SELECT *  from T_XBBNHFQ_Hotel ";
			try {
				 stmt = conn.prepareStatement(searchQuery);
					
				 resultset = stmt.executeQuery();	
				
	
				while(resultset.next()) {
				
					HotelBean hbean =new HotelBean();
					hbean.setHotelname(resultset.getString(2));
					hbean.setLocation(resultset.getString(4));
					hbean.setAddress(resultset.getString(3));
					hbean.setLevel(resultset.getInt(5));
					hbean.setRating(resultset.getInt(6));
					hbean.setHid(resultset.getInt(1));
					
					HotelList.add(hbean);
							
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
			
			return HotelList;
			
		}
	public void insertHotel(HotelBean hb) 

	{
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		System.out.println("1.Hotelid  2.Hotel name 3.address 4.Location 5.Level 6.Rating ");
		try{
		String str="INSERT INTO T_XBBNHFQ_HOTEL VALUES(?,?,?,?,?,?)";
		
		System.out.println(""+hb.getHid()+hb.getHotelname()+hb.getAddress()+hb.getLocation()+hb.getLevel()+hb.getRating());
		stmt=conn.prepareStatement(str);
		stmt.setInt(1,hb.getHid());
		stmt.setString(2,hb.getHotelname());
		stmt.setString(3,hb.getAddress());
		stmt.setString(4,hb.getLocation());
		stmt.setInt(5,hb.getLevel());
		stmt.setInt(6,hb.getRating());
		stmt.execute();
		}
		catch(SQLException e)
		{
			System.out.print("insertion errror"+e);
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
	public void deleteHotel(HotelBean hb) {

		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		try{
		String str="DELETE FROM T_XBBNHFQ_Hotel WHERE  name=? and address=? and Location=?";
		stmt=conn.prepareStatement(str);
		
			//stmt.setInt(1,hb.getHid());	
		stmt.setString(1,hb.getHotelname());
		stmt.setString(2,hb.getAddress());
		stmt.setString(3, hb.getLocation());
	stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.print("deletion errror");
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
