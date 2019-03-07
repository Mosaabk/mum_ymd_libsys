package com.ymd.libsys;

import com.alibaba.fastjson.JSON;

public class SuperUser {
	
	public static void addUser(User user) {
		String usersPath = "src/com/ymd/libsys/dataaccess/users";
		String res = MyTool.readStringFromFile(usersPath);
		if (res.equals("")) {
			Users users = new Users();
			users.getUserHash().put(user.getUserName(), user);
			String userString = JSON.toJSONString(users);
			MyTool.WriteStringToFile(userString, usersPath);
		} else {
			String jsonDataString = MyTool.readStringFromFile(usersPath);
			Users users = JSON.parseObject(jsonDataString, Users.class);
			users.getUserHash().put(user.getUserName(), user);
			String userString = JSON.toJSONString(users);
			MyTool.WriteStringToFile(userString, usersPath);
		}
	}
	
	public static int checkUserType(User user) {
		String usersPath = "src/com/ymd/libsys/users";
		String res = MyTool.readStringFromFile(usersPath);
		try {
			
			if (!res.equals("")) {
				Users users = JSON.parseObject(res, Users.class);
				User u = users.getUserHash().get(user.getUserName());
				if(u.getPassword().equals(user.getPassword())) {
					return u.getUserType();
				}
			}

		}
		catch(Exception e) {}
		return -1;
	}
	
	public static boolean verifyUser(User user) {
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUserName("mosap");
		user.setPassword("123");
		user.setUserType(3);
		addUser(user);
	}

}
