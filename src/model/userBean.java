package model;

import connector.SqlConnection;

public class userBean {
	
	String username,password;
	
	
	
	public userBean(String username,String password) {
		this.username = username;
		this.password = password;
		
	}
	
	public boolean validating () {
		
		if (SqlConnection.userValidatorAgainstDatabase(username, password)) {
			return true;
		}else {
			return false;
		}
		
		//needs to send username and password to 
		
		
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;	
	}
	
	
	
	
	
// gonna save user and validate ? validated is called once then we know if its true or not
}
