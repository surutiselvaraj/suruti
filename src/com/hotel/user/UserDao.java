package com.hotel.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.hotel.ConnectionManager;

public class UserDao {
public  List getUserDetails(String emailid)
{
	Connection conn = ConnectionManager.getConnection();
	PreparedStatement stmt = null;
	List UserList = null;
	Scanner sc=new Scanner(System.in);
	ResultSet resultset = null;
	
	
		 String searchQuery = "SELECT *  from T_XBBNHFQ_USERDETAILS where emailid=?";
	try {
		 stmt = conn.prepareStatement(searchQuery);
		stmt.setString(1, emailid);		
			
		 resultset = stmt.executeQuery();	
		
		 UserList = new ArrayList<UserBean>();
		 
		while(resultset.next()) {
			UserBean userBean = new UserBean();
			userBean.setFirstname(resultset.getString(1));
			userBean.setLastname(resultset.getString(2));
			userBean.setAddress(resultset.getString(3));
			userBean.setDistrict(resultset.getString(4));
			userBean.setEmailid(resultset.getString(5));
			userBean.setContactno(resultset.getLong(6));

			UserList.add(userBean);
					
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
	
	return UserList;
	
	
		
}
public void updateProfile(String s1,String s2,Long s3,String emailid,String first){
Connection conn = ConnectionManager.getConnection();
PreparedStatement stmt = null;
List RoomList = null;



String searchQuery = "update T_XBBNHFQ_USERDETAILS set address=?, district=?,contactno=? where emailid=? and firstname = ?";

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
