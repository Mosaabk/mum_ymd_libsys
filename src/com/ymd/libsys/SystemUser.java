package com.ymd.libsys;

public class SystemUser {
	
	private String userName;
	
	private String password;
	
	private enum Role{Administrator, Librarian, Super;}
	
	private Role role;
	
	public static SystemUser getUser(String userName, String password) {
		SystemUser u = new SystemUser(userName, password);
		
		return u;
	}
	
	SystemUser(String userName, String password,Role role){
		this(userName, password);
		this.role = role;
	}
	
	public SystemUser(String userName, String password){
		this.userName = userName;
		this.password = password;
	}
	
	
	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
	

	public Role getRole() {
		return role;
	}

	public int login(String userName, String password) {
		
		this.userName = userName;
		this.password = password;
		
		User u = new User();
		u.setUserName(userName);
		u.setPassword(password);
		
		return SuperUser.checkUserType(u);
		
	}

}
