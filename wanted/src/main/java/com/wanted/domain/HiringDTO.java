package com.wanted.domain;

import java.util.HashMap;

public class HiringDTO {
	private Integer hiring_id;
	private String company_id;
	private String title;
	private String content;
	private String reward;
	private String skill;
	
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public Integer getHiring_id() {
		return hiring_id;
	}
	public void setHiring_id(Integer hiring_id) {
		this.hiring_id = hiring_id;
	}
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReward() {
		return reward;
	}
	public void setReward(String reward) {
		this.reward = reward;
	}
	
	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> hiringMap = new HashMap<String, Object>();
		
		hiringMap.put("company_id", this.getCompany_id());
		hiringMap.put("content", this.getContent());
		hiringMap.put("reward", this.getReward());
		hiringMap.put("skill", this.getSkill());
		hiringMap.put("title", this.getTitle());
		
		return hiringMap;
	}
	
	@Override
	public String toString() {
		return "hiringDTO [hiring_id=" + hiring_id + ", company_id=" + company_id + ", title=" + title + ", content="
				+ content + ", reward=" + reward + ", skill=" + skill + "]";
	}
	
	
}