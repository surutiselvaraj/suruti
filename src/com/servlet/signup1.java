package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.Hotel01Dao;
import com.hotel.user.UserBean;


@WebServlet("/signup1")
public class signup1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public signup1() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Hotel01Dao hotel01dao = new Hotel01Dao();
		UserBean ub=new UserBean();
		
		long contactno;
			response.setContentType("text/html");  
			  ub.setFirstname(request.getParameter("Firstname"));
			  ub.setLastname(request.getParameter("Lastname"));
			  ub.setAddress(request.getParameter("Address"));
			  ub.setDistrict(request.getParameter("district"));
			  ub.setEmailid(request.getParameter("emailid"));
			  ub.setPassword(request.getParameter("psw"));
			  ub.setContactno(contactno=Long.parseLong(request.getParameter("mobileno")));
			 // System.out.println(fname+lname+address+district+emailid+contactno+psw);
		 hotel01dao.signup( ub);
		 RequestDispatcher rd=request.getRequestDispatcher("password1.html");
		 
	  rd.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
