package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.Hotel01Dao;
import com.hotel.manager.ManagerDao;

//import com.inautix.hotel.Hotel01Dao;

@WebServlet("/password")
public class password extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public password() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Hotel01Dao hotel01dao = new Hotel01Dao();
		response.setContentType("text/html");  
		Hotel01Dao hotel01dao = new Hotel01Dao();
		ManagerDao mdao  = new ManagerDao();
		 String password1,loginid;
		response.setContentType("text/html"); 
			  loginid=request.getParameter("username");
			  password1=request.getParameter("psw");
			  HttpSession session=request.getSession(true);
              session.setAttribute("user_id",loginid);
              RequestDispatcher rd = null;
              if(loginid.equals("admin@gmail.com"))
{ rd=request.getRequestDispatcher("ViewAllBookings.jsp");
rd.forward(request,response);
}

             // else if(loginid.equals("abi@gmail.com"))
              else if(mdao.managerloginvalidate(loginid,password1))
{ rd=request.getRequestDispatcher("ViewManagerProfile.jsp");
rd.forward(request,response);
}

              else if(hotel01dao.loginvalidate(loginid,password1))
				  {	 rd=request.getRequestDispatcher("front.jsp");
            	  rd.forward(request,response);
            	//  response.sendRedirect("front.jsp");
				  }
			
              else
              {
            	  System.out.println("yuku");
				  PrintWriter out=response.getWriter();
 rd=request.getRequestDispatcher("password2.jsp");
				 out.print("Sorry  Wrong id or password Please Try Again");
			  rd.include(request,response);
				  }
	}

	

}
