package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;

import utils.DbUtils;

public class StoreManagerDAOImpl implements StoreManagerDAO{
	
private Connection conn;
	
	public StoreManagerDAOImpl()
	{
		conn=DbUtils.getConnection();
	}
	
	public boolean addProduct(String productid, String productretailer, double productprice, String producttype)
	{
		boolean result=false;
		
		try{
		
		String insertIntoProductQuery = "INSERT INTO products(productid,productretailer,productprice, producttype) "+ "VALUES (?,?,?,?);";
		PreparedStatement pst = conn.prepareStatement(insertIntoProductQuery);
		pst.setString(1,productid);
		pst.setString(2,productretailer);
		pst.setDouble(3,productprice);
		pst.setString(4,producttype);
		
		int result1=pst.executeUpdate();
		System.out.println("result is" + result1);
		if (result1==1)
				{
			result=true;
				}
		else
		{
			result= false;
		}
		
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	return result;	
		
	}
	public boolean deleteProduct(String productid)
	{
		
			boolean result=false;
		
		try{
		
		String deleteProduct = "DELETE FROM products where productid=?";
		System.out.println("deleted query is" + deleteProduct);
		PreparedStatement pst = conn.prepareStatement(deleteProduct);
		pst.setString(1,productid);
		int result1=pst.executeUpdate();
		System.out.println("result is" + result1);
		if (result1==1)
				{
			result=true;
				}
		else
		{
			result= false;
		}
		
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	return result;	
		
		
		
		
	}
	public boolean updateProduct(String productid, String productretailer, double productprice)
	{
		
boolean result=false;
		
		try{
		
		String updateProductQuery = "UPDATE products set productretailer=?, productprice=? where productid=?";
		PreparedStatement pst = conn.prepareStatement(updateProductQuery);
		
		pst.setString(1,productretailer);
		pst.setDouble(2,productprice);
		pst.setString(3,productid);
		
		int result1=pst.executeUpdate();
		System.out.println("result is" + result1);
		if (result1==1)
				{
			result=true;
				}
		else
		{
			result= false;
		}
		
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	return result;	
		
		
	}
	
	
	
	

}
