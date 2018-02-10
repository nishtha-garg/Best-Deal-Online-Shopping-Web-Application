package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import pojos.Order;
import pojos.Product;
import utils.DbUtils;

public class OrderDAOImpl implements OrderDAO {

	private Connection conn=null;
	
	public OrderDAOImpl()
	{
		conn=DbUtils.getConnection();
	}
	
	
	public List<Integer> insertOrders(String username,List<Product> productList)
	{
		List<Integer> idList= new ArrayList<>();
		String insertIntoCustomerRegisterQuery = "INSERT INTO customerorders(username,productid,productcost,orderstatus, deliverydate) "+ "VALUES (?,?,?,?,?);";
		
		try
		{
			
			SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy");
			
			Calendar c = Calendar.getInstance();
			c.setTime(new Date()); // Now use today date.
			c.add(Calendar.DATE, 5); // Adding 5 days
			String output = sdf.format(c.getTime());
			Date deliverydate= sdf.parse(output);
		PreparedStatement pst = conn.prepareStatement(insertIntoCustomerRegisterQuery, Statement.RETURN_GENERATED_KEYS);
			for(Product p:productList)
			{
			pst.setString(1,username);
			pst.setString(2,p.getProductId());
			pst.setDouble(3,p.getProductPrice());
			pst.setString(4,"ordered");
			pst.setDate(5,new java.sql.Date(deliverydate.getTime()));
			
			
			 int affectedRows = pst.executeUpdate();

		        if (affectedRows == 0) {
		            throw new SQLException("Creating user failed, no rows affected.");
		        }

		         ResultSet generatedKeys = pst.getGeneratedKeys();
		            if (generatedKeys.next()) {
		               
		            	idList.add((int)generatedKeys.getLong(1));
		            	
		            
		            }
		            else {
		               
		            }
		        }
	
			
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		System.out.println("idList is"+ idList);
		return idList;
	}
	
	public List<Order> orderListForUser(String username)
	{
	String query="select * from customerorders where username=?";
	List<Order> orderList=new ArrayList<Order>();
	try{
		PreparedStatement pst = conn.prepareStatement(query);
		pst.setString(1,username);
		
		
		ResultSet rs = pst.executeQuery();
		
		while (rs.next())
		{
			orderList.add(new Order(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDate(5),rs.getDate(6),rs.getString(7)));
			
		}
			
		} catch (Exception e)
		{e.printStackTrace();}
	return orderList;
	
			
	
	}
	
	
	public int deliverOrder(int orderid)
	{
		
		int result=0;
		try{
		String query="update customerorders set orderstatus='delivered' where orderid=?";
		PreparedStatement pst= conn.prepareStatement(query);
		pst.setInt(1, orderid);
		
		result=pst.executeUpdate();
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	return result;
	
	}
	
	
	
	
	
	
	
	
	public int cancelOrder(int orderid)
	{
		
		int result=0;
		try{
		String query="update customerorders set orderstatus='cancelled' where orderid=?";
		PreparedStatement pst= conn.prepareStatement(query);
		pst.setInt(1, orderid);
		
		result=pst.executeUpdate();
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	return result;
	
	}
	
	public List<Order> getAllOrders()
	{
		
		String query="select * from customerorders";
		List<Order> orderList=new ArrayList<Order>();
		try{
			PreparedStatement pst = conn.prepareStatement(query);
			
			
			
			ResultSet rs = pst.executeQuery();
			
			while (rs.next())
			{
				orderList.add(new Order(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDate(5),rs.getDate(6),rs.getString(7)));
				
			}
				
			} catch (Exception e)
			{e.printStackTrace();}
		return orderList;
		
		
		
	}
}
