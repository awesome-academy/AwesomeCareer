package com.aa.awesomecareer.model;

public class SkillModel {
	private Integer id;
	private String name;
	private Integer userId;
	private UserModel userModel;
	
	public SkillModel() {
	
	}
	
	public SkillModel(Integer id, String name, Integer userId, UserModel userModel) {
		super();
		this.id = id;
		this.name = name;
		this.userId = userId;
		this.userModel = userModel;
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
	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
