package daos;

public interface LoginDAO 
{
	boolean isValidUser(String username, String password, String role);
	boolean insertUser(String username, String password, String role);
}