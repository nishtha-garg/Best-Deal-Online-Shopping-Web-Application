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

import pojos.LaptopBean;
import pojos.Product;
import pojos.TabletBean;
import services.StoreManagerService;
import services.StoreManagerServiceImpl;


public class addProduct extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StoreManagerService service= new StoreManagerServiceImpl();
	
	
	
		
		ServletContext context=getServletContext();
		 HashMap<String, Product> productMap= (HashMap<String, Product>)context.getAttribute("productmap");
		 System.out.println("product map is"+ productMap);
		 String productid=request.getParameter("productid");
		 String productretailer=request.getParameter("productname");
		 Double productprice=(Double.parseDouble(request.getParameter("productprice")));
		 String producttype=request.getParameter("producttype");
		 int switchcondition=producttype.equals("laptop")?0:1;
		 
		 
		 boolean result=service.addProduct(productid, productretailer, productprice, producttype);
		 if (result)
		 {
			 switch (switchcondition)
			 {
				 case 0:
				 {
			 	productMap.put(productid, new LaptopBean(productid, productretailer, productprice, producttype));
		 		RequestDispatcher rd= request.getRequestDispatcher("products");
		 		rd.forward(request, response);
		 		
			 	break;
				 } 
				 
				 case 1:
				 {
			 	productMap.put(productid, new TabletBean(productid, productretailer, productprice, producttype));
			 	RequestDispatcher rd= request.getRequestDispatcher("products");
		 		rd.forward(request, response);
		 		break;
				 } 
				
			 }
		 } 
		 else
		 {
			 PrintWriter out= response.getWriter();
			 out.write("failed to add the product");
		 }
		 
		
		
		
	}

}
	
