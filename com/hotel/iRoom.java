package com.hotel;

import java.util.List;

public interface iRoom {

	public void signup(String fname,String lname,String address,String district,String emailid,Long contactno,String password);
	 public List roomDetails();
	 public Boolean isAvailability(int hid,int roomid,String s);
	 public void bookRoom();
	 public void cancelBooking(int hid,int rid,String s1,String s2);
	 public void updateBooking(int hid,int rid,String s1,String s2,String s3);

}
