package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.Product;


public class deleteFromCart extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		HttpSession session=request.getSession();
		Map<String, Product> mapp = (HashMap)session.getAttribute("sessionCart");	
		String id=request.getParameter("id");
		System.out.println("attribute value is " + mapp + "in do delete method");
		mapp.remove(id);
		session.setAttribute("sessionCart",mapp);
		
		RequestDispatcher rd=request.getRequestDispatcher("cart");  
	rd.forward(request, response);	
	
	

}
}