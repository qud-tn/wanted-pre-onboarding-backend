package com.wanted.domain;

public class ApplicationDTO {
	private String member_id;
	private Integer hiring_id;
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public Integer getHiring_id() {
		return hiring_id;
	}
	public void setHiring_id(Integer hiring_id) {
		this.hiring_id = hiring_id;
	}

	@Override
	public String toString() {
		return "ApplicationDTO [member_id=" + member_id + ", hiring_id=" + hiring_id + "]";
	}

}
