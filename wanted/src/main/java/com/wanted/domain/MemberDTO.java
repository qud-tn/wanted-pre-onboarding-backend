package com.wanted.domain;

public class MemberDTO {
	private String Member_id;
	private String password;
	
	public String getMember_id() {
		return Member_id;
	}
	public void setMember_id(String member_id) {
		Member_id = member_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [Member_id=" + Member_id + ", password=" + password + "]";
	}
	
}
