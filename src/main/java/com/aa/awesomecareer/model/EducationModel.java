package com.aa.awesomecareer.model;

import java.util.Date;

public class EducationModel {
	
	private Integer id;
	private Integer userId;
	private String school;
	private String major;
	private String description;
	private Date graduation;
	
	private UserModel userModel;

	public EducationModel() {
		
	}

	public EducationModel(Integer id, Integer userId, String school, String major, String description, Date graduation,
			UserModel userModel) {
		super();
		this.id = id;
		this.userId = userId;
		this.school = school;
		this.major = major;
		this.description = description;
		this.graduation = graduation;
		this.userModel = userModel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getGraduation() {
		return graduation;
	}

	public void setGraduation(Date graduation) {
		this.graduation = graduation;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}