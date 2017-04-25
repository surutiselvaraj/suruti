package com.hotel;

import java.sql.*;
import java.util.*;


public class ConnectionManager {

   static Connection con;
   static String url;
         
   public static Connection getConnection()
   {
     
      try
      {
         String url = "jdbc:odbc:" + "DataSource"; 
         // assuming "DataSource" is your DataSource name

     	//Class.forName("oracle.jdbc.driver.OracleDriver");
     	Class.forName("org.apache.derby.jdbc.ClientDriver");
                    	
            try {
				//con = DriverManager.getConnection("jdbc:oracle:thin:@10.232.71.29:1521:INATP02","shobana","shobana");
				  con=DriverManager.getConnection("jdbc:derby://172.24.21.39:1527/hotel","user","pwd");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             								
         // assuming your SQL Server's	username is "username"               
         // and password is "password"
              
         
         
      }

      catch(ClassNotFoundException e)
      {
         System.out.println(e);
      }

   return con;
}
}