package listener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import pojos.Product;
import utils.DbUtils;

public class AppContextListener implements ServletContextListener {

	
	private Connection conn= null;
	private HashMap<String,Product> productmap;
	private HashMap<String,Integer> switchmap;
	
	public void contextDestroyed(ServletContextEvent arg0) {
	
	}

	
	public void contextInitialized(ServletContextEvent e) {
		
		System.out.println("in the contextInitialized method");
		try{
		
			switchmap=new HashMap<String, Integer>();
			switchmap.put("laptop", 1);
			switchmap.put("tablet", 2);
			
			
			
			
		conn=DbUtils.getConnection();
		
		System.out.println("connection is"+ conn);
		
		
		
		Statement st= conn.createStatement();
		st.executeUpdate("truncate products");
		
		
		productmap=new HashMap<String, Product>();
		
		ServletContext ctx=e.getServletContext();
		ctx.setAttribute("productmap", productmap);
		ctx.setAttribute("switchmap", switchmap);
		
		for (Product p: productmap.values())
		{
			
			
			String insertProduct="INSERT INTO products(productid,productretailer,productprice,producttype) "+ "VALUES (?,?,?,?);";
			PreparedStatement pst = conn.prepareStatement(insertProduct);
			pst.setString(1,p.getProductId());
			pst.setString(2,p.getProductRetailer());
			pst.setDouble(3,p.getProductPrice());
			pst.setString(4,p.getProductType());
			
			
			
			int result1=pst.executeUpdate();
			
			System.out.println("result is"+ result1);
		
		
		}
			} catch(Exception es)
			{
				es.printStackTrace();
			}
			
			
			
		}
		
		
		
		
		
		
		
	

}
