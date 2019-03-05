package com.ymd.libsys;

import com.alibaba.fastjson.JSON;

public class Administrator {
	
	public static void addNewBook() {
		
	}
	
	public static void addCopyBook() {
		
	}
	
	public static void addLibraryMember(Member member) {
		String membersPath = "src/com/ymd/libsys/members";
		String res = MyTool.readStringFromFile(membersPath);
		if (res.equals("")) {
			Members members = new Members();
			member.setId(0);
			members.getMembers().add(member);
			String memberString = JSON.toJSONString(members);
			MyTool.WriteStringToFile(memberString, membersPath);
		} else {
			String jsonDataString = MyTool.readStringFromFile(membersPath);
			Members members = JSON.parseObject(jsonDataString, Members.class);
			
			int len = members.getMembers().size();
			int lastId = members.getMembers().get(len - 1).getId();
			lastId++;
			member.setId(lastId);
			
			members.getMembers().add(member);
			String memberString = JSON.toJSONString(members);
			MyTool.WriteStringToFile(memberString, membersPath);
		}
		
	}
	
	public static void EditLibraryMember() {
		
	}
	
	public static void main(String[] args) {
      
      
  }

}
