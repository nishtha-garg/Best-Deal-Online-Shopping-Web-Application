package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.Product;
import services.LoginService;
import services.LoginServiceImpl;


public class Login extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LoginService service= new LoginServiceImpl();
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		String role= request.getParameter("usertype");
		boolean isUserValid= service.isValidUser(username, password,role);

					if(isUserValid)
					{
						if(role.equals("customer")){
						HttpSession session= request.getSession();
						session.setAttribute("username",username);		
						Map<String, Product> cartMap= new HashMap <String,Product>();
						
						session.setAttribute("sessionCart", cartMap);
								RequestDispatcher rd=request.getRequestDispatcher("customer.html");  
							rd.forward(request, response);
						}
						else if (role.equals("storemanager"))
						{
							HttpSession session= request.getSession();
							session.setAttribute("username",username);		
							RequestDispatcher rd=request.getRequestDispatcher("storemanager.html");  
								rd.forward(request, response);
						}
						
						else if (role.equals("salesman"))
						{
							HttpSession session= request.getSession();
							session.setAttribute("username",username);		
							RequestDispatcher rd=request.getRequestDispatcher("salesman.html");  
								rd.forward(request, response);
						}
					}
					
					else
					{
						PrintWriter out=response.getWriter();
						out.println("Login Failed");
					}	



		
		
	}

}
