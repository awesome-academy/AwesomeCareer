package com.aa.awesomecareer.model;

import javax.persistence.Column;

import com.aa.awesomecareer.entity.User;

public class ExperienceModel extends BaseModel {
	
	private Integer id;
	private Integer userId;
	private String companyName;
	private String jobTitle;
	private String startYear;
	private String startMonth;
	private String endYear;
	private String endMonth;
	private String description;
	private boolean currentlyWork;
	private boolean internship;
	private User user;
	
	public ExperienceModel() {
	
	}
	
	public ExperienceModel(Integer id, String companyName, String jobTitle, String startYear, String startMonth,
			String endYear, String endMonth, String description, boolean currentlyWork, boolean internship) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.jobTitle = jobTitle;
		this.startYear = startYear;
		this.startMonth = startMonth;
		this.endYear = endYear;
		this.endMonth = endMonth;
		this.description = description;
		this.currentlyWork = currentlyWork;
		this.internship = internship;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getStartYear() {
		return startYear;
	}
	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}
	public String getStartMonth() {
		return startMonth;
	}
	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}
	public String getEndYear() {
		return endYear;
	}
	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}
	public String getEndMonth() {
		return endMonth;
	}
	public void setEndMonth(String endMonth) {
		this.endMonth = endMonth;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCurrentlyWork() {
		return currentlyWork;
	}

	public void setCurrentlyWork(boolean currentlyWork) {
		this.currentlyWork = currentlyWork;
	}

	public boolean isInternship() {
		return internship;
	}

	public void setInternship(boolean internship) {
		this.internship = internship;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}