package com.aa.awesomecareer.service;

import java.util.List;

import com.aa.awesomecareer.model.UserModel;

public interface UserService {
	public List<UserModel> findAll();

	public UserModel findByEmail(String email);

	public UserModel findUserById(Integer id);

	void addUser(UserModel userModel);

	public void saveSkill(UserModel userModel);
	
	public UserModel saveIntroduction(UserModel userModel);

	UserModel saveAmbition(UserModel userModel);
	
	public UserModel findUser(Integer id);

	UserModel saveInfo(UserModel userModel);
}
