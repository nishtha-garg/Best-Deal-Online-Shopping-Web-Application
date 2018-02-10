package servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.LaptopBean;
import pojos.Product;
import utils.DbUtils;

public class DealMatches extends HttpServlet {
	
	private Connection conn= null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter out = response.getWriter();
		response.setContentType("text/html");


		out.println("<html>");
out.println("<head>");
out.println("<title>best match--homepage</title>");
out.println("<meta http-equiv='Content-Type' content='text/html; charset=iso-8859-1' />");
//out.println("<link href='style.css'; rel='stylesheet'; type='text/css' />");
out.println("</head>");
/*out.println("<body bgcolor='#550403' style='leftmargin=0px; topmargin=10px; marginwidth=0px; marginheight=0px;'>");
out.println("<span class='style6'></span");

out.println("<div id='body'>");
out.println("<br />");
out.println("<br />");
out.println("<br />");
 out.println("<table style='width=1001px; height=1001px;' border='0' align='center' cellpadding='0' cellspacing='0' id='Table_01'>");
    out.println("<tr>");
      out.println("<td colspan='2' rowspan='3'><div id='logo'>");
      out.println("<div class='logo'><a href='index.html'><span class='style5'>BEST<br />");
	  out.println("DEAL</span></a></div>");
      out.println("</div></td>");
out.println("<td colspan='3'><div class='style1' id='header'>");
			out.println("<br />");
			out.println("ONLINE <span class='style3'>SHOPPING</span>");
             out.println("<span class='style4'><br />");
                     out.println("</span></div></td>");
	      out.println("<td>");
		      out.println("<img src='images/spacer.gif' width='1' height='185' alt='' /></td>");
      out.println("</tr>");
    out.println("<tr>");
      out.println("<td><div class='top_menu'>");
      out.println("<ul>");
      out.println("<li><a href='index.html'>HOME</a></li>");
      out.println("<li><a href='SignIn.html'>SIGNIN</a></li>");
      out.println("<li><a href='NewAccount.html'>NEW ACCOUNT</a></li>");
      out.println("<li><a href='Contact.html'>CONTACT US</a></li>");
      out.println("</ul>");
      out.println("</div></td>");
	    out.println("<td colspan='2'>");
	        out.println("<img src='images/index_04.jpg' width='128' height='42' alt='' /></td>");
	    out.println("<td>");
	        out.println("<img src='images/spacer.gif' width='1' height='42' alt='' /></td>");
      out.println("</tr>");
    out.println("<tr>");
      out.println("<td colspan='2' rowspan='2'><div id='content'>");
      out.println("<div class='title'></div>");
      out.println("<div class='content'>");

	*/
out.println("<body>");
      conn=DbUtils.getConnection();
      HashMap<String,Product> selectedproducts=new HashMap<String,Product>();
     
      
    	  out.println("<div class='entry'>");
    	  out.println("<h3> We beat all our competitors in all aspects. </h3><h2>PRICE-MATCH GUARANTEED</h2>");
    	  String line=null;
    	  ServletContext sct=getServletContext();
    	  
    	  HashMap<String,Product> productmap=(HashMap<String,Product>)sct.getAttribute("productmap");
    	  
     
    			  for(Map.Entry<String, Product>entry:productmap.entrySet())
    			  {
    			  	if(selectedproducts.size()<2 && !selectedproducts.containsKey(entry.getKey()))
    			  	{
    			  		BufferedReader reader=new BufferedReader(new FileReader(new File("C:/apache-tomcat-7.0.34/webapps/BestDeal/DealMatches.txt")));
    			  		
    			  		line=reader.readLine();
    			  		
    			  		
    			  		System.out.println("line read is "+ line);
    			  		if(line==null)
    			  		{
    			  			System.out.println("in block if line =null");
    			  			out.print("<h2 align='center' No offers found</h2>");
    			  			break;
    			  			
    			  		}
    			  		else
    			  			
    			  		{
    			  			System.out.println("entry in else block");
    			  		do{
    			  			if(line.contains(entry.getValue().getProductRetailer()))
    			  			{
								int index=0;
    			  		index=line.indexOf("http");
    			  				System.out.println("in block if line is not null and value is matched");
    			  			out.print(line.substring(0,index));
    			  			out.print("<a href='"+line.substring(index,line.length())+"'>" + line.substring(index,line.length())+ "</a>");
    			  			out.print("<br>");
    			  			selectedproducts.put(entry.getKey(),entry.getValue());
    			  			break;
    			  			}
    			  			
    			  		}
    			  		while((line=reader.readLine())!=null);
    			  			
    			  		}
    			  	}
    			  
    			  }
      
    			  out.println("<h2> DEAL MATCHES:</h2>");
      
    			  
    			  for(Map.Entry<String,Product> entry: selectedproducts.entrySet())
    				{
    					Product product= entry.getValue();
    					
    					out.println("<form method='post' action='hello'>");
    					 
    					out.println("<b>" + product.getProductRetailer() + "</b>"); 
    					out.println("<input type ='hidden' name='retailer' value='"+ product.getProductRetailer()+"'>");
    					
    					out.println("<a>Product Id: "  + product.getProductId() + "</a>"+"<br/>");
    					out.println("<input type ='hidden' name='id' value='"+ product.getProductId()+"'>");
    					
    					out.println("<a>Price: $"  + product.getProductPrice() + "</a>");
    					out.println("<input type ='hidden' name='price' value='"+ product.getProductPrice()+"'>");
    					
    					out.println("<input type ='hidden' name='type' value='1'>");
    					out.println("<input type='submit' value='Add to cart'/>");
    					
    					out.println("</form>");
    					
    					out.println("<form method='post' action='Review.html'>");
    					out.println("<input type='submit' value='Add Review'/>");	
    					out.println("</form>");
    					
    					out.println("<form method='get' action='ViewReview.jsp'>");
    					out.println("<input type='submit' value='View Review'/>");
    					out.println("<input type ='hidden' name='id' value='"+product.getProductId()+"'/>");
    					out.println("</form>");
    			        
    			       } 
      
      
      
      

out.println("</body>");
out.println("</html>");
		
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
