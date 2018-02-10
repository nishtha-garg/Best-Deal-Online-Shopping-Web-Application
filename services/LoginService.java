package services;

public interface LoginService
{
	boolean isValidUser(String username, String password, String role);
	boolean insertUser(String username, String password, String role);
}