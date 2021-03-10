package com.aa.awesomecareer.model;

import java.util.Date;

public class ExperiencesModel extends BaseModel {
	private Integer experiencesID;
	private String companyName;
	private String title;
	private Date startWorkTime;
	private Date endWorkTime;
	private String description;
	
	public Integer getExperiencesID() {
		return experiencesID;
	}
	public void setExperiencesID(Integer experiencesID) {
		this.experiencesID = experiencesID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getStartWorkTime() {
		return startWorkTime;
	}
	public void setStartWorkTime(Date startWorkTime) {
		this.startWorkTime = startWorkTime;
	}
	public Date getEndWorkTime() {
		return endWorkTime;
	}
	public void setEndWorkTime(Date endWorkTime) {
		this.endWorkTime = endWorkTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
