package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.LoginService;
import services.LoginServiceImpl;


public class insertUser extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		LoginService service=new LoginServiceImpl();

		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String role=request.getParameter("usertype");

		boolean res= service.insertUser(username, password, role);
		if (res==true)
		{
			response.sendRedirect("SignIn.html");
			
		}
		else
		{
			PrintWriter out=response.getWriter();
			out.println("The username" + username + "already exists");
			
			
		}
		
		
		
	}
	
}
