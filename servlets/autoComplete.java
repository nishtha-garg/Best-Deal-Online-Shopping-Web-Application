package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.AjaxUtility;

public class autoComplete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		String searchId=request.getParameter("searchId");
		
		System.out.println("in auto complete servlet, action is" + action + "   search id is"+ searchId);
		try
		{
		StringBuffer sb = null;
		boolean namesAdded = false;
		if (action.equals("complete"))
		{
			if (!"".equals(searchId))
				{ AjaxUtility a=new AjaxUtility();
					sb=a.readdata(searchId);
					System.out.println("content of string buffer is" +sb);
					if(sb!=null || !sb.equals(""))
					{
						namesAdded=true;
					}
					if (namesAdded)
					{
						System.out.println("finally writing response");
					response.setContentType("text/xml");
					response.getWriter().write("<products>" + sb.toString() + "</products >");
					}
				}
		}
	} catch (Exception e)
		{
		e.printStackTrace();
		}
	}

	}
