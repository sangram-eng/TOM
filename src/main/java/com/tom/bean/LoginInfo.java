package com.tom.bean;

import com.tom.entity.Login;

public class LoginInfo {
	
	private String id;
	private String email;
	private String password;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Login convertToEntity() 
	 {
		
	    	Login  login= new  Login();
			if(id!=null  && id!="0")			
			login.setId(Long.valueOf(id));
			login.setEmail(email);
			login.setPassword(password);

			return login;
}
}
