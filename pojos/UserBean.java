package pojos;


import java.io.Serializable;

public class UserBean {

	private String userName;
	private String passWord;
	private String role;
	
	
	public UserBean()
	{}
	
	public UserBean(String userName, String passWord, String role)
	{
		this.userName = userName;
		this.passWord = passWord;
		this.role = role;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean equals(Object obj)
	{
			if(obj instanceof UserBean)
			{
				UserBean user=(UserBean)obj;
				
				if(userName.equals(user.getUserName()) && passWord.equals(user.getPassWord()) && role.equals(user.getRole()))
				{return true; }
				else{
				return false;}
			}
			else
			{
				
			return false;
				}				
		}

	
}
