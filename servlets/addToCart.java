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

import pojos.LaptopBean;
import pojos.Product;
import pojos.TabletBean;

public class addToCart extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Map<String, Product> mapp = (HashMap)session.getAttribute("sessionCart");	


		System.out.println("In the cartservlet,   listp is" + mapp);
		String retailer=request.getParameter("retailer");

		System.out.println("username is " + retailer);

		String id=request.getParameter("id");
		String price=request.getParameter("price");
		System.out.println("price is " + price + " id is" + id);
		 Double finalprice=Double.parseDouble(price);

		Integer productType=Integer.parseInt(request.getParameter("type"));
		switch (productType)
		{
			case 1:
			
			
				LaptopBean lp= new LaptopBean (id, retailer, finalprice);
				mapp.put(id, lp);
				session.setAttribute("sessionCart", mapp);
				break;
				
			case 2:
				TabletBean tb= new TabletBean (id, retailer, finalprice);
				mapp.put(id, tb);
				session.setAttribute("sessionCart", mapp);
				break;
		}	 

		RequestDispatcher rd=request.getRequestDispatcher("customer.html");  
		rd.forward(request, response);


		
		
	}

}
