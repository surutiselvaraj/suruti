package com.hotel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



import com.hotel.ConnectionManager;
import com.hotel.user.UserBean;
import org.apache.log4j.Logger;
public class Hotel01Dao //implements iRoom

{
static int no=10;

final static Logger logger = Logger.getLogger(Hotel01Dao.class);
public void signup(UserBean ub) {

	Connection conn=null;
	try
		{ conn = ConnectionManager.getConnection();}catch(Exception e){System.out.println("not Connnnection ");}
		PreparedStatement stmt = null;
		logger.info("ghkj");
			try
		{
		String str="INSERT INTO T_XBBNHFQ_USERDETAILS(firstname,lastname,address,district,emailid,contactno) VALUES(?,?,?,?,?,?)";
		stmt=conn.prepareStatement(str);

		
			stmt.setString(1,ub.getFirstname());
			stmt.setString(2,ub.getLastname());
			stmt.setString(3,ub.getAddress());
			stmt.setString(4,ub.getDistrict());
			stmt.setString(5,ub.getEmailid());
			stmt.setLong(6,ub.getContactno());
			stmt.execute();
		}
		catch(Exception e)
		{
			System.out.println("exception in userlogin 2 details "+e);
		}
		try
		{
			String str="INSERT INTO T_XBBNHFQ_LOGIN(loginid,password) VALUES(?,?)";
			stmt=conn.prepareStatement(str);
			stmt.setString(1,ub.getEmailid());
			stmt.setString(2,ub.getPassword());
			stmt.execute();
		}
		catch(Exception e)
		{
			System.out.println("exception in login details "+e);
		}
		finally
		{
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

public boolean loginvalidate(String loginid,String password)
{
	Connection conn = ConnectionManager.getConnection();
	PreparedStatement stmt = null;
		ResultSet resultset = null;

	String searchQuery = "SELECT *  from T_XBBNHFQ_LOGIN where loginid=? and password=?";
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
public String Searchq(int hid)
{
	Connection conn = ConnectionManager.getConnection();
	PreparedStatement stmt = null;
	List RoomList = null;
	String hname= null; 
	ResultSet resultset = null;
	
	 String searchQuery = "SELECT *  from T_XBBNHFQ_Hotel where hid=? ";
	try {
		 stmt = conn.prepareStatement(searchQuery);
		stmt.setInt(1, hid);		
		 resultset = stmt.executeQuery();	
		while(resultset.next()) {
			
			hname=(resultset.getString(2));
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
	
	return hname;
}
public int Search(String hname)
{
	Connection conn = ConnectionManager.getConnection();
	PreparedStatement stmt = null;
	List RoomList = null;
	
	ResultSet resultset = null;
	int hid=0;
	 String searchQuery = "SELECT hid  from T_XBBNHFQ_Hotel where name=? ";
	try {
		 stmt = conn.prepareStatement(searchQuery);
		stmt.setString(1, hname);		
		 resultset = stmt.executeQuery();	
		while(resultset.next()) {
			
			hid=(resultset.getInt(1));
		}
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}	
		 searchQuery = "SELECT *  from T_XBBNHFQ_ROOM where hid=? order by rid ";
	try {
		 stmt = conn.prepareStatement(searchQuery);
		stmt.setInt(1, hid);		
		 resultset = stmt.executeQuery();	
		
		 RoomList = new ArrayList<RoomBean>();
		 
		while(resultset.next()) {
			RoomBean roomBean = new RoomBean();
			roomBean.setRid(resultset.getInt(6));
			roomBean.setIsAc(resultset.getBoolean(1));
			roomBean.setNo_Of_cot(resultset.getInt(2));
			roomBean.setGrade(resultset.getInt(3));
			roomBean.setLivingSpace(resultset.getInt(4));
			roomBean.setHid(resultset.getInt(7));
			roomBean.setCost(resultset.getInt(5));
			RoomList.add(roomBean);
					
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
	
	return hid;
			
}
public List BookingDetails(String loginid){
	Connection conn = ConnectionManager.getConnection();
	PreparedStatement stmt = null;
	List BookedList = null;
	ResultSet resultset = null;
	
	
		 String searchQuery = "SELECT *  from T_XBBNHFQ_Bookings b join T_XBBNHFQ_Hotel h on b.hid=h.hid where b.loginid=? ";
	try {
		 stmt = conn.prepareStatement(searchQuery);
		stmt.setString(1, loginid);		
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

	public List roomDetails(int hid,int rid){
	
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		List RoomList = null;
		Scanner sc=new Scanner(System.in);
		ResultSet resultset = null;
		
		
			 String searchQuery = "SELECT *  from T_XBBNHFQ_ROOM where hid=?and rid=? ";
		try {
			 stmt = conn.prepareStatement(searchQuery);
			stmt.setInt(1, hid);		
			stmt.setInt(2, rid);		
			 resultset = stmt.executeQuery();	
			
			 RoomList = new ArrayList<RoomBean>();
			 
			while(resultset.next()) {
				RoomBean roomBean = new RoomBean();
				roomBean.setRid(resultset.getInt(6));
				roomBean.setIsAc(resultset.getBoolean(1));
				roomBean.setNo_Of_cot(resultset.getInt(2));
				roomBean.setGrade(resultset.getInt(3));
				roomBean.setLivingSpace(resultset.getInt(4));
				roomBean.setHid(resultset.getInt(7));
				roomBean.setCost(resultset.getInt(5));
				RoomList.add(roomBean);
						
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
		
		return RoomList;
		
		
			
	}

	public List rooms(int hid){
		//step 3: create statement object 
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		List RoomList = null;
		ResultSet resultset = null;
		
		
			 String searchQuery = "SELECT *  from T_XBBNHFQ_ROOM where hid=?";
		try {
			 stmt = conn.prepareStatement(searchQuery);
			stmt.setInt(1, hid);		
				
			 resultset = stmt.executeQuery();	
			
			 RoomList = new ArrayList<RoomBean>();
			 
			while(resultset.next()) {
				RoomBean roomBean = new RoomBean();
				roomBean.setRid(resultset.getInt(6));
				roomBean.setIsAc(resultset.getBoolean(1));
				roomBean.setNo_Of_cot(resultset.getInt(2));
				roomBean.setGrade(resultset.getInt(3));
				roomBean.setLivingSpace(resultset.getInt(4));
				roomBean.setHid(resultset.getInt(7));
				roomBean.setCost(resultset.getInt(5));
				RoomList.add(roomBean);
						
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
				}}
	return RoomList;
			
	}

	public Boolean isAvailability(int hid,int roomid,String s) {
	
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		Boolean isavailable=true;
		Date d=new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		try {
			d=df.parse(s);
			} 
		catch (ParseException e1) {
			
			e1.printStackTrace();
		}
		ResultSet resultset = null;
		String searchQuery = "SELECT *  from T_XBBNHFQ_BOOKINGS  where RID=? and hid in (select hid from T_XBBNHFQ_hotel)";
	
		try {
			 stmt = conn.prepareStatement(searchQuery);
			 stmt.setInt(1,roomid);
			// stmt.setInt(2,hid);
			 resultset = stmt.executeQuery();
			 while(resultset.next()) 
			 { 
				 if(resultset.getDate(4).compareTo(d)>0 || resultset.getDate(5).compareTo(d)<0)
				 {
					
					 isavailable= true;
				 }
						 
				 else 
				 { System.out.println("Room  booked by "+resultset.getString(6));
				 return false;
				 }
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
	
		return isavailable;
	}
	
	public void cancelBooking(BookingBean bb)
{
	Connection conn = ConnectionManager.getConnection();
	PreparedStatement stmt = null;
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
//	String searchQuery = "delete  '"+d+"''from T_XBBNHFQ_BOOKINGS where RID = ? and fromdate=? and todate=? and hid=?";
	String searchQuery = "delete from T_XBBNHFQ_BOOKINGS where RID = ? and fromdate=? and todate=? and hid=?";
	try {
		 stmt = conn.prepareStatement(searchQuery);
			stmt.setInt(1, bb.getRid());	
		stmt.setDate(2, sqld1);	
		stmt.setDate(3, sqld2);
		stmt.setInt(4, bb.getHid());
	
		stmt.executeUpdate();
	}
	catch(Exception e)
	{
		System.out.println("exception in queery");
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
		public List availabilityRoom(String hotel,String s1,String s2) {
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		ResultSet resultset = null;
		ResultSet resultset2 = null;
		List RoomList = null;
		Date d1=null,d2=null;
		int hid=Search(hotel);
		if(hid!=0)
		{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try{
		d1=sdf.parse(s1);
		d2=sdf.parse(s2);
		} 
		catch (ParseException e1) {
			System.out.println("date error");
			//e1.printStackTrace();
		}
		String searchQuery = "SELECT *  from T_XBBNHFQ_BOOKINGS  where hid=?";
		
		//String searchQuery = "SELECT *  from T_XBBNHFQ_Room s LEFT JOIN T_XBBNHFQ_BOOKINGS t ON s.hid=t.hid where s.hid=?";
	HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
		try {
			 stmt = conn.prepareStatement(searchQuery);
			 stmt.setInt(1,hid);
			 resultset = stmt.executeQuery();
			 while(resultset.next()) 
			 { 
				 if((resultset.getDate(3).compareTo(d1)>0 || (resultset.getDate(3).compareTo(d1)<0) && (resultset.getDate(3).compareTo(d2)<0 )))
						 //|| resultset.getDate(4).compareTo(d2)>0)
				 {
					
					 if(!(hm.containsKey(resultset.getInt(2))))
					 {
						 hm.put(resultset.getInt(2), 1);
							System.out.println("avail"+(resultset.getDate(3))+(resultset.getDate(3))+(resultset.getInt(2)));
					 }
				 }
						 
				 else 
				 { //System.out.println("Room  booked by "+resultset.getString(5));
				 hm.put(resultset.getInt(2),0);
				System.out.println("bcoz"+(resultset.getDate(3))+(resultset.getDate(4))+(resultset.getInt(2)));
				 }
			 }
			 String searchQuery2 = "SELECT *  from T_XBBNHFQ_Room s  where s.hid=?";
			 stmt2 = conn.prepareStatement(searchQuery2);
			 stmt2.setInt(1,hid);
			 resultset2 = stmt2.executeQuery();
			 while(resultset2.next()) 
			 { 
				 if(!(hm.containsKey(resultset2.getInt(2))))
				 {
					 hm.put(resultset2.getInt(6), 1);}}
			 
			 RoomList = new ArrayList<RoomBean>();
			 for(Map.Entry m:hm.entrySet()){  
				 int a=(int)m.getKey(); 
				 if((int)m.getValue()==1)
				 { System.out.println(a+" "); 
				 searchQuery = "SELECT *  from T_XBBNHFQ_ROOM where  rid=? and hid=?";
					try {
						 stmt = conn.prepareStatement(searchQuery);
						stmt.setInt(1, a);	
						 stmt.setInt(2,hid);
						 resultset = stmt.executeQuery();	
						
						
						 
						while(resultset.next()) {
							RoomBean roomBean = new RoomBean();
							roomBean.setRid(resultset.getInt(6));
							roomBean.setIsAc(resultset.getBoolean(1));
							roomBean.setNo_Of_cot(resultset.getInt(2));
							roomBean.setGrade(resultset.getInt(3));
							roomBean.setLivingSpace(resultset.getInt(4));
							roomBean.setHid(resultset.getInt(7));
							roomBean.setCost(resultset.getInt(5));
							roomBean.setType(resultset.getString(8));
						roomBean.setHotelname(Searchq(resultset.getInt(7)));
							RoomList.add(roomBean);
									
						}
						
						
					} catch (SQLException e) {
						
						e.printStackTrace();
					}	
				 } 
				  }  
		} 
		catch (SQLException e) {
		
			e.printStackTrace();
		}finally{
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
		}}
		else
		{
			
			PreparedStatement stmt3 = null;
			List RoomList2 = null;
			ResultSet resultset3 = null;
			
			
			String searchQuery3= "SELECT *  from T_XBBNHFQ_ROOM r join T_XBBNHFQ_HOTEL h on r.hid=h.hid where  h.location=?";
			try {
				 stmt3 = conn.prepareStatement(searchQuery3);
				stmt3.setString(1, hotel);		
				 resultset3 = stmt3.executeQuery();	
				
				 RoomList = new ArrayList<RoomBean>();
				 
				while(resultset3.next()) {
					RoomBean roomBean = new RoomBean();
					roomBean.setRid(resultset3.getInt(6));
					roomBean.setIsAc(resultset3.getBoolean(1));
					roomBean.setNo_Of_cot(resultset3.getInt(2));
					roomBean.setGrade(resultset3.getInt(3));
					roomBean.setLivingSpace(resultset3.getInt(4));
					roomBean.setHid(resultset3.getInt(7));
					roomBean.setCost(resultset3.getInt(5));
					roomBean.setType(resultset3.getString(8));
					roomBean.setHotelname(resultset3.getString(10));
					roomBean.setAddress(resultset3.getString(11));
					roomBean.setLocation(resultset3.getString(12));
					roomBean.setLevel(resultset3.getInt(13));
					roomBean.setRating(resultset3.getInt(14));
					RoomList.add(roomBean);
							
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
		}}
		return RoomList;
		}
	
		public void bookRoom(BookingBean bb) {
		Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = null;
			ResultSet resultset = null;
			
			Date d1=null,d2=null;
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			try{
			d1=sdf.parse(bb.getFromdate());
			d2=sdf.parse(bb.getTodate());
			} 
			catch (ParseException e1) {
				
				e1.printStackTrace();
			}
		java.sql.Date sqlDate1 = new java.sql.Date(d1.getTime());
		java.sql.Date sqlDate2= new java.sql.Date(d2.getTime());
	
		try{
		String str="INSERT INTO T_XBBNHFQ_BOOKINGS VALUES(?,?,?,?,?)";
		stmt=conn.prepareStatement(str);
		}
		catch(SQLException e)
		{
			System.out.print("iquery nsertion errror");
		}		try{
		stmt.setInt(1,bb.getHid());
		
		stmt.setInt(2,bb.getRid());
		}
		catch(SQLException e)
		{
			System.out.print("int insertion errror");
		}		try{
		
		stmt.setDate(3,sqlDate1);
		stmt.setDate(4,sqlDate2);
		stmt.setString(5,bb.getLoginid());
}
catch(SQLException e)
{
	System.out.print(" date insertion errror");
}		try{
		stmt.execute();
//		System.out.println("segjrhghgj");
		}
		catch(SQLException e)
		{
			System.out.print("  insertion errror"+e);
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
		
	}
		
		public void updateBooking(BookingBean bb)
	{

		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		List RoomList = null;
		Date fromdate=null,todate=null,newtodate=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try{
		fromdate=sdf.parse(bb.getFromdate());
		todate=sdf.parse(bb.getTodate());
		newtodate=sdf.parse(bb.getNewtodate());
		}
		
		catch(Exception e)
		{
			System.out.println("exception");
		}
		java.sql.Date sqld1 = new java.sql.Date(fromdate.getTime());
		java.sql.Date sqld2= new java.sql.Date(todate.getTime());
		java.sql.Date sqld3= new java.sql.Date(newtodate.getTime());
		String searchQuery = "update T_XBBNHFQ_BOOKINGS set todate=? where hid=? and RID = ? and fromdate=? and todate=?";
		//String searchQuery = "update T_XBBNHFQ_BOOKINGS set todate=? where hid=?  and fromdate=? and todate=?";
		try {
			 stmt = conn.prepareStatement(searchQuery);
			 stmt.setInt(2, bb.getHid());	
			stmt.setInt(3,bb.getRid());	
			stmt.setDate(4, sqld1);	
			stmt.setDate(5, sqld2);
			stmt.setDate(1, sqld3);
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
