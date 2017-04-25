package com.controller;

 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.hotel.BookingBean;
import com.hotel.ConnectionManager;
  
public class DelAd extends JdbcDaoSupport {  
private JdbcTemplate jdbcTemplate;  
  
public void setJdbcTemplate1(JdbcTemplate jdbcTemplate) {  
    this.jdbcTemplate = jdbcTemplate;  
}  
  
public int cancelBooking1(BookingBean bb){ 
	List RoomList = null;
	Date fromdate=null,todate=null;
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	try{
	fromdate=sdf.parse(bb.getFromdate());
	todate=sdf.parse(bb.getTodate());
	}
	
	catch(Exception e)
	{
		System.out.println("exceptionh"+e);
	}
	java.sql.Date sqld1 = new java.sql.Date(fromdate.getTime());
	java.sql.Date sqld2= new java.sql.Date(todate.getTime());

	String searchQuery = "delete from T_XBBNHFQ_BOOKINGS where RID ="+bb.getRid()+" and fromdate='"+sqld1+"' and todate='"+sqld2+"' and hid="+bb.getHid();
	
	return  getJdbcTemplate().update(searchQuery);
	
	}
		

  
     
}  
  
