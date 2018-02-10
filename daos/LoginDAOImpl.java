package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;
import pojos.UserBean;
import utils.DbUtils;

public class LoginDAOImpl implements LoginDAO
{
	private Connection conn;
	
	public LoginDAOImpl()
	{
		conn=DbUtils.getConnection();
	}
	public boolean isValidUser(String username, String password, String role)
	{
		
		System.out.println("in isValidUser, "+ username + "		"+ password);
		
		Map<String,UserBean>userMap2=DbUtils.getUserFromDb();
		
		System.out.println("map retrieved from DB is "+ userMap2 );
		
		
		UserBean user=	new UserBean(username, password, role);
		if(userMap2.containsKey(username) && userMap2.get(username).equals(user))  
			{
			return true;
			}
			else
			{
				return false;
			}
		
	}
	
		public boolean insertUser(String username, String password, String role)
		{
			boolean result=false;
			try{
				
					Map<String,UserBean> userMap=DbUtils.getUserFromDb();
					if(userMap.containsKey(username))
					{
						
						
						System.out.println("The UserName "+ username +" already exists");
					result=false;	
					}
						
						
					
					else
					{
					String insertIntoCustomerRegisterQuery = "INSERT INTO user(username,password,usertype) "+ "VALUES (?,?,?);";
					PreparedStatement pst = conn.prepareStatement(insertIntoCustomerRegisterQuery);
					pst.setString(1,username);
					pst.setString(2,password);
					pst.setString(3,role);
					
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
				
					}
				
				}
				
						catch(Exception e)
						{
							e.printStackTrace();
						}
			
			
			return result;
			
			
		}
	

}