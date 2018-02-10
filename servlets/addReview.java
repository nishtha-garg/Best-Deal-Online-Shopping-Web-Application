package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;


public class addReview extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			 Mongo mongo = new Mongo("localhost", 27017);
			 DB db = mongo.getDB("BestDealDatabase");

			 DBCollection collection = db.getCollection("NewReview");
			 
			 String rtext1=request.getParameter("userid1");
			String id=request.getParameter("id");
			String rtext3=request.getParameter("userid3");

			String rtext4=request.getParameter("userid4");

			String rtext5=request.getParameter("userid5");

			String rtext6=request.getParameter("userid6");
			String rtext7=request.getParameter("userid7");
			String rtext8=request.getParameter("userid8");

			String rtext9=request.getParameter("userid9");

			String rtext10=request.getParameter("userid10");

			String userid=request.getParameter("userid11");

			String rtext12=request.getParameter("userid12");
			String rtext13=request.getParameter("userid13");

			 String rtext14=request.getParameter("userid14");
			Float rtext15=Float.parseFloat(request.getParameter("userid15"));
			String rtext16=request.getParameter("userid16");
			String rtext17=request.getParameter("userid17");


			 System.out.println("BasicDBObject example...");
			 System.out.println("id is"+ id + "   length is  " + id.length());
			 
			 BasicDBObject document = new BasicDBObject();
			 
			 document.put("PRODUCT_MODEL_NAME", rtext1);
			  document.put("PRODUCT_ID", id);
			  document.put("PRODUCT_PRICE", rtext3);
			    document.put("RETAILER_NAME", rtext4);
				  document.put("RETAILER_ZIP", rtext5);
			  document.put("RETAILER_CITY", rtext6);
			    document.put("RETAILER_STATE", rtext7); 
				document.put("PRODUCTON_SALE", rtext8);
				  document.put("MANUFACTURER_NAME", rtext9);
				    document.put("MANUFACTURER_REBATE", rtext10);
					  document.put("USER_ID", userid);
			 document.put("USER_AGE", rtext12);
			  document.put("USER_GENDER", rtext13);
			    document.put("USER_OCCUPATION", rtext14); 
				document.put("REVIEW_RATING", rtext15);
				  document.put("REVIEW_DATE", rtext16);
				    document.put("REVIEW_TEXT", rtext17);

					
			 collection.insert(document);
			
			 
			RequestDispatcher rd=request.getRequestDispatcher("customer.html");  
			rd.forward(request, response);
					}

			
			
			catch(Exception e)
			{
				e.printStackTrace();
				
			}

	}

}
