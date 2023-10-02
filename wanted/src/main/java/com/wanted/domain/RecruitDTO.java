package com.wanted.domain;

import java.util.HashMap;
import java.util.List;

public class RecruitDTO {
	private int recruit_id;
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
	public int getRecruit_id() {
		return recruit_id;
	}
	public void setRecruit_id(int recruit_id) {
		this.recruit_id = recruit_id;
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
		HashMap<String, Object> recruitMap = new HashMap<String, Object>();
		
		recruitMap.put("company_id", this.getCompany_id());
		recruitMap.put("content", this.getContent());
		recruitMap.put("reward", this.getReward());
		recruitMap.put("skill", this.getSkill());
		recruitMap.put("title", this.getTitle());
		
		return recruitMap;
	}
	
	@Override
	public String toString() {
		return "RecruitDTO [recruit_id=" + recruit_id + ", company_id=" + company_id + ", title=" + title + ", content="
				+ content + ", reward=" + reward + ", skill=" + skill + "]";
	}
	
	
}