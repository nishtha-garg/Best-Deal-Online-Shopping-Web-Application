package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import pojos.LaptopBean;
import pojos.TabletBean;
import utils.DbUtils;

public class TabletDAOImpl implements TabletDAO {

	
	
private Connection conn;
	
	public TabletDAOImpl()
	{
		conn=DbUtils.getConnection();
	}
	
	public Map<String, TabletBean> tabletsList() {
		
		Map<String,TabletBean>tabletMap = new HashMap< String,TabletBean>();
		 

		String selectAllUsers ="select productid, productretailer, productprice from products where producttype='tablet'";
		

		try{
		PreparedStatement pst = conn.prepareStatement(selectAllUsers);
		ResultSet rs = pst.executeQuery();
		
		while (rs.next())
		{
			tabletMap.put(rs.getString(1),new TabletBean(rs.getString(1),rs.getString(2),rs.getDouble(3)));
			
		}
			
		} catch (Exception e)
		{e.printStackTrace();}
			
	
		return tabletMap;
	}
}
