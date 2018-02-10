package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.Product;
import services.OrderService;
import services.OrderServiceImpl;

public class hello extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	PrintWriter out = response.getWriter();
	


	out.println("<html>");
out.println("<head>");
out.println("<title>hello--homepage</title>");
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
  out.println("<li><a href='index.html'>Home</a></li>");
  out.println("<li><a href='SignIn.html'>SignIn</a></li>");
  out.println("<li><a href='NewAccount.html'>New Account</a></li>");
  out.println("<li><a href='Contact.html'>Contact Us</a></li>");
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

  
  
  out.println("<br>");
  out.println("<br>");
  out.println("<h1><font color='red'> SIGN IN FIRST TO CONTINUE!!!</font></h1>");


	
	out.println("<font color='black'>THANK YOU FOR CHOOSING BEST DEAL!!!</font>");
	
  
  
	  
	  
	  
  
  
  
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
    out.println("<li><a href='TvServlet/a></li>");
	
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
    out.println("<td></td>");
  out.println("</tr>");
out.println("</table>");
out.println("<div id='lft'><a href='http://www.merkkleding-outlet.nl'>merkkleding online</a></div><br />");
out.println("<br />");
out.println("</div>");

out.println("</body>");
out.println("</html>");
	
	}
}
