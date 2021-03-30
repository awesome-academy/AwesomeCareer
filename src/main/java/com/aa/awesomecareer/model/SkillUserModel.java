package com.aa.awesomecareer.model;

import com.aa.awesomecareer.entity.Skill;
import com.aa.awesomecareer.entity.User;

public class SkillUserModel {
	private Integer id;
	private Integer userId;
	private Integer skillId;
	
	private SkillModel skillModel;
	private UserModel userModel;
	
	public SkillUserModel() {
	
	}
    
	public SkillUserModel(Integer id, Integer userId, Integer skillId, SkillModel skillModel, UserModel userModel) {
		super();
		this.id = id;
		this.userId = userId;
		this.skillId = skillId;
		this.skillModel = skillModel;
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

	public Integer getSkillId() {
		return skillId;
	}

	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}



	public SkillModel getSkillModel() {
		return skillModel;
	}



	public void setSkillModel(SkillModel skillModel) {
		this.skillModel = skillModel;
	}



	public UserModel getUserModel() {
		return userModel;
	}



	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	
}
