package com.wanted.domain;

public class MemberDTO {
	private String member_id;

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	@Override
	public String toString() {
		return "MemberDTO [member_id=" + member_id + "]";
	}
	
	
}
