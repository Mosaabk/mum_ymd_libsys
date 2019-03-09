package com.ymd.libsys;

import com.alibaba.fastjson.JSON;

public class Member extends Person {
	private int id;
	private int indx;
	public Member() {
		super();
	}
	
	
	public String getStreet() {
		return this.getAddress().street;
	}
	public String getCity() {
		return this.getAddress().city;
	}
	public String getState() {
		 return this.getAddress().state;
	}
	public String getZipCode() {
		return this.getAddress().zipCode;
	}
	
	
	public static Member addMember(String firstName, String lastName, String phoneNum, Address address) {
		Member m = new Member(firstName, lastName, phoneNum, address);
		m.id = 0;

		try {
			
			String filePath = "src/com/ymd/libsys/dataaccess/members";
			String res = MyTool.readStringFromFile(filePath);
			Members members;
			if (!res.equals("")) {
				members = JSON.parseObject(res, Members.class);
				m.id = members.getMembers().size();
			}
			else {
				members = new Members();
			}
			m.id = m.id>0? m.id + 10001 : 10001;
			
			members.getMembers().add(m);
			String membersString = JSON.toJSONString(members);
			MyTool.WriteStringToFile(membersString, filePath);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		
		return m;
	}
	
	public Member(String firstName, String lastName, String phoneNum, Address address){
		super(firstName, lastName, phoneNum, address);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public static Member getMember(int id) {
		try {
			
			String filePath = "src/com/ymd/libsys/dataaccess/members";
			String res = MyTool.readStringFromFile(filePath);
			Members members;
			if (!res.equals("")) {
				members = JSON.parseObject(res, Members.class);
			}
			else {
				members = new Members();
			}
			
			for(int i = 0; i< members.getMembers().size(); i++) {
				Member mi = members.getMembers().get(i);
				if(mi.getId() == id)
				{
					mi.indx = i;
					return mi;
				}
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		

		return null;
	}
	
	public boolean editMember(Member m) {
		boolean result = false;

		try {
			
			String filePath = "src/com/ymd/libsys/dataaccess/members";
			String res = MyTool.readStringFromFile(filePath);
			Members members;
			if (!res.equals("")) {
				members = JSON.parseObject(res, Members.class);
			}
			else {
				members = new Members();
			}
			
			members.getMembers().set(this.indx, m);
			String membersString = JSON.toJSONString(members);
			MyTool.WriteStringToFile(membersString, filePath);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		
		return result;
	}
	
}
