package com.hotel.admin;

import java.util.Scanner;

public class AdminMainApp {
	public static void main(String args[]){
	int ch=1;
	String cha="yes";
	Scanner sc=new Scanner(System.in);
	AdminDao admindao = new AdminDao();
	do{
		
		System.out.println("do you want to"); 
		System.out.println("1.Insert  a room ");
		System.out.println("2.Insert a hotel");
		System.out.println("3.Cancel a hotel");
		System.out.println("4.Update room details");
		System.out.println("5.View all Bookings");

			ch=sc.nextInt();
	switch(ch)
	{
	case 1:
		System.out.println("enter the record you want to insert");
		admindao.viewManagerDetails();
		break;
	}	System.out.println("do you want to continue");
	cha=sc.next();
	}while(!(cha.equals("no")));
	System.out.println("thank you");
	}
	}
