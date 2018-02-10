package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionContext;

import pojos.Product;
import services.StoreManagerService;
import services.StoreManagerServiceImpl;

public class deleteProduct extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StoreManagerService service= new StoreManagerServiceImpl();
		ServletContext context=getServletContext();
		 HashMap<String, Product> productMap= (HashMap<String, Product>)context.getAttribute("productmap");
		 
		 String productid=request.getParameter("productid");

		 boolean result=service.deleteProduct(productid);
		 if (result)
		 {
			 productMap.remove(productid);
				RequestDispatcher rd= request.getRequestDispatcher("products");
				rd.forward(request, response);
			 
		 }
		 else
		 {
			 PrintWriter out = response.getWriter();


				out.println("failed to delete the product");
		
			 
		 }
	}

}
