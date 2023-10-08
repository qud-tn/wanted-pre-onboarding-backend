package com.wanted.domain;

public class CompanyDTO {
	private String Company_id;
	private String location;
	public String getCompany_id() {
		return Company_id;
	}
	public void setCompany_id(String company_id) {
		Company_id = company_id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "CompanyDTO [Company_id=" + Company_id + ", location=" + location + "]";
	}
	
}
