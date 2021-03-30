package com.aa.awesomecareer.model;

import java.util.Date;

import com.aa.awesomecareer.entity.User;

public class ExperienceModel extends BaseModel {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer userId;
	private String companyName;
	private String jobTitle;
	private Date startTime;
	private Date endTime;
	private String description;
	private boolean currentlyWork;
	private boolean internship;
	private User user;
	
	public ExperienceModel() {
	
	}
	
	public ExperienceModel(Integer id, Integer userId, String companyName, String jobTitle, Date startTime,
			Date endTime, String description, boolean currentlyWork, boolean internship, User user) {
		super();
		this.id = id;
		this.userId = userId;
		this.companyName = companyName;
		this.jobTitle = jobTitle;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
		this.currentlyWork = currentlyWork;
		this.internship = internship;
		this.user = user;
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}