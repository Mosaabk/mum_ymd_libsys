package com.ymd.libsys;

import java.util.HashMap;

public class Users {
	
	private HashMap<String, User> userHash;
	
	public Users() {
		userHash = new HashMap<String, User>();
	}

	public HashMap<String, User> getUserHash() {
		return userHash;
	}

	public void setUserHash(HashMap<String, User> userHash) {
		this.userHash = userHash;
	}
	
}
