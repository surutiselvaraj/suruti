package com.hotel;
import java.util.*;
import java.io.*;
public class RoomMainApp {

	public static void main(String[] args) {
		int roomid = 301;
		Date D=null;
		String cha="yes";
		int ch=1,hid;
		Scanner sc=new Scanner(System.in);
		Hotel01Dao hotel01dao = new Hotel01Dao();
		
		String s="2017-05-28",s1="2017-06-01",s2="2017-06-07",s3="2017-06-14";
		System.out.print("Hotel Management");
		do{
		System.out.println("do you want to");
		System.out.println("1.Sign up ");
		System.out.println("2.get Room details ");
		System.out.println("3.Check Availabilitiy for a Room");
		System.out.println("4.Book Room");
		System.out.println("5.cancel Booking ");
		System.out.println("6.Update Booking ");
		
		
			ch=sc.nextInt();
	switch(ch)
	{
	
		case 1:
		String fname,lname,address,district,emailid;
			long contactno;
			//hotel01dao.signup("subash","bose","pune","mumbai","subash2gmail.com",8877665544L,"sastra");
			break;
		case 2:
			List<RoomBean> roomList = hotel01dao.availabilityRoom("Chennai","2017-08-01","2017-08-05");
			//.availabilityRoom("2017-07-05","2017-07-07");
			//List<RoomBean> roomList = hotel01dao.roomDetails();
			 Iterator<RoomBean> itr =  roomList.iterator();
			 System.out.println("");
				System.out.println("Hotel ID\troomid\tLiving space\tis Ac\tNo. of cot\tGrade\tcost");
			while(itr.hasNext()){
			
				RoomBean roomBean = itr.next();
				
				
				System.out.println(roomBean.getHid()+"\t\t"+roomBean.getRid()+"\t"+roomBean.getLivingSpace()+"\t\t"+roomBean.getIsAc()+"\t"+roomBean.getNo_Of_cot()+"\t"
						+ "\t"+roomBean.getGrade()+"\t"+roomBean.getCost());
				
				
		}
			System.out.println("");
			System.out.println("");
			break;
		case 3:
			System.out.println("Enter the hotel id");
			hid=sc.nextInt();
			System.out.println("Enter the room id");
			roomid=sc.nextInt();
			System.out.println("Enter the date");
			s=sc.next();
	Boolean availability=hotel01dao.isAvailability(hid,roomid,s);
	if(availability==true)
		System.out.println("the room is available");
	else
		System.out.println("the room is not available");
	break;
		case 4:
		System.out.println("enter the room details you want to book");
		//hotel01dao.availabilityRoom(1001,"2017-07-05","2017-07-07");
		//hotel01dao.bookRoom();
		break;
		case 5:
			System.out.println("Enter the hotel id");
			hid=sc.nextInt();
			System.out.println("Enter the room id");
			roomid=sc.nextInt();
			System.out.println("Enter the check in date");
			s1=sc.next();
			System.out.println("Enter the check out date");
			s2=sc.next();
		//hotel01dao.cancelBooking(hid,roomid, s1, s2);
		break;
		case 6:
			System.out.println("Enter the hotel id");
			hid=sc.nextInt();
			System.out.println("Enter the room id");
			roomid=sc.nextInt();
			System.out.println("Enter the check in date");
			s1=sc.next();
			System.out.println("Enter the old check out date");
			s2=sc.next();
			System.out.println("Enter the new check out date");
			s3=sc.next();
	///	hotel01dao.updateBooking(hid,roomid, s1, s2, s3);
		break;
		
		
		
	}
	System.out.println("do you want to continue");
	cha=sc.next();
		}while(!(cha.equals("no")));
		System.out.println("thank you");
	}}