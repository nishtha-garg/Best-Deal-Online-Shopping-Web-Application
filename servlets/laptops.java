package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.LaptopBean;
import services.LaptopService;
import services.LaptopServiceImpl;


public class laptops extends HttpServlet {
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out = response.getWriter();
		


		out.println("<html>");
out.println("<head>");
out.println("<title>Laptops--homepage</title>");
out.println("<meta http-equiv='Content-Type' content='text/html; charset=iso-8859-1' />");
out.println("<link href='style.css'; rel='stylesheet'; type='text/css' />");
out.println("</head>");
out.println("<body bgcolor='#550403' style='leftmargin=0px; topmargin=10px; marginwidth=0px; marginheight=0px;'>");
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
      out.println("<li><a href='customer.html'>search</a></li>");
      out.println("<li><a href='index.html'>SignOut</a></li>");
      out.println("<li><a href='cart'>Cart</a></li>");
      out.println("<li><a href='viewOrder'>Orders</a></li>");
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

	  
      LaptopService service=new LaptopServiceImpl();
	  Map<String,LaptopBean>laptopMap = service.laptopsList();
	  
	  
	  for(Map.Entry<String,LaptopBean> entry: laptopMap.entrySet())
		{
			LaptopBean laptop= entry.getValue();
			
			out.println("<form method='post' action='addToCart'>");
			 
			out.println("<b>" + laptop.getProductRetailer() + "</b>"); 
			out.println("<input type ='hidden' name='retailer' value='"+ laptop.getProductRetailer()+"'>");
			
			out.println("<a>Product Id: "  + laptop.getProductId() + "</a>"+"<br/>");
			out.println("<input type ='hidden' name='id' value='"+ laptop.getProductId()+"'>");
			
			out.println("<a>Price: $"  + laptop.getProductPrice() + "</a>");
			out.println("<input type ='hidden' name='price' value='"+ laptop.getProductPrice()+"'>");
			
			out.println("<input type ='hidden' name='type' value='1'>");
			out.println("<input type='submit' value='Add to cart'/>");
			
			out.println("</form>");
			
			out.println("<form method='post' action='Review.html'>");
			out.println("<input type='submit' value='Add Review'/>");	
			out.println("</form>");
			
			out.println("<form method='get' action='ViewReview.jsp'>");
			out.println("<input type='submit' value='View Review'/>");
			out.println("<input type ='hidden' name='id' value='"+laptop.getProductId()+"'/>");
			out.println("</form>");
	        
	       } 
      
     out.println("</div>");
      out.println("</div></td>");
      
	    out.println("<td rowspan='3'>");
	        out.println("<img src='images/index_06.jpg'     width='27'     height='773'     alt='    '     /></td>");
	    out.println("<td>");
	        out.println("<img src='images/spacer.gif'     width='1'     height='76'     alt='    '     /></td>");
      out.println("</tr>");
    out.println("<tr>");
      out.println("<td rowspan='2'    ><img src='images/index_07.jpg'     width='70'     height='697'     alt='    '    /></td>");
      out.println("<td><div class='left_menu'>");
        out.println("<ul>");
        
        out.println("<li><a href='laptops'>LAPTOPS</a></li>");
        out.println("<li><a href='tablets'>TABLETS</a></li>");
        out.println("<li><a href='PhoneServlet'>PHONES</a></li>");
        
        out.println("<li><a href='trending.html'>TRENDING</a></li>");
        out.println("</ul>");
        out.println("</div></td>");
	    out.println("<td>");
	        out.println("<img src='images/spacer.gif' width='1'height='651' alt='' /></td>");
      out.println("</tr>");
    out.println("<tr>");
      out.println("<td colspan='3'><div id='footer'></div></td>");
  out.println("<td>");
	        out.println("<img src='images/spacer.gif' width='1' height='46' alt='' /></td>");
      out.println("</tr>");
    out.println("<tr>");
      out.println("<td>");
        out.println("<img src='images/spacer.gif' width='70' height='1' alt='' /></td>");
	    out.println("<td>");
	        out.println("<img src='images/spacer.gif' width='179' height='1' alt='' /></td>");
	    out.println("<td>");
	        out.println("<img src='images/spacer.gif' width='623' height='1' alt='' /></td>");
	    out.println("<td>");
	        out.println("<img src='images/spacer.gif' width='101' height='1' alt='' /></td>");
	    out.println("<td>");
	        out.println("<img src='images/spacer.gif' width='27' height='1' alt='' /></td>");
	    
      out.println("</tr>");
  out.println("</table>");
  out.println("<div id='lft'><a href='http://www.merkkleding-outlet.nl'>merkkleding online</a></div><br />");
  out.println("<br />");
out.println("</div>");

out.println("</body>");
out.println("</html>");
	}

}
