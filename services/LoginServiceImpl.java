package services;

import daos.LoginDAO;
import daos.LoginDAOImpl;

public class LoginServiceImpl implements LoginService
{
	private LoginDAO logindao;
	
	
	public LoginServiceImpl()
	{
		this.logindao=new LoginDAOImpl();
		
	}
	public boolean isValidUser(String username, String password, String role)
	{
		return logindao.isValidUser(username,password,role);
		
	}
	
	
	public boolean insertUser(String username, String password, String role)
	{
		return logindao.insertUser(username, password, role);
		
		
	}
	
}