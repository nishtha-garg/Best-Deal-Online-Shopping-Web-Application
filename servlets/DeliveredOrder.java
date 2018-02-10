package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.OrderService;
import services.OrderServiceImpl;

public class DeliveredOrder extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String orderid=request.getParameter("id ");
		System.out.println("id is" + orderid);
		
		int id=Integer.parseInt(orderid);
		
		
		
		OrderService service=new OrderServiceImpl();
		int result= service.deliverOrder(id);
		
		
		if(result==1)
		{
			RequestDispatcher rd=request.getRequestDispatcher("salesman.html");
			rd.forward(request, response);
			
		}
		
		else
		{
			PrintWriter out =response.getWriter();
			out.write("failed to change the order status");
			
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
