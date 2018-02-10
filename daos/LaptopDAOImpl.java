package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import pojos.LaptopBean;
import pojos.TabletBean;
import utils.DbUtils;

public class LaptopDAOImpl implements LaptopsDAO {

	
	
private Connection conn;
	
	public LaptopDAOImpl()
	{
		conn=DbUtils.getConnection();
	}
	
	public Map<String, LaptopBean> laptopsList() {
		
		Map<String,LaptopBean>laptopMap = new HashMap< String,LaptopBean>();
		 

		String selectAllUsers ="select productid, productretailer, productprice from products where producttype='laptop'";
		

		try{
		PreparedStatement pst = conn.prepareStatement(selectAllUsers);
		ResultSet rs = pst.executeQuery();
		
		while (rs.next())
		{
			laptopMap.put(rs.getString(1),new LaptopBean(rs.getString(1),rs.getString(2),rs.getDouble(3)));
			
		}
			
		} catch (Exception e)
		{e.printStackTrace();}
			
	
		return laptopMap;
	}
}
