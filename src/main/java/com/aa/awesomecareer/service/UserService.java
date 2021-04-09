package com.aa.awesomecareer.service;

import java.util.List;

import com.aa.awesomecareer.model.UserModel;

public interface UserService {
	public List<UserModel> findAll();
	
	public UserModel findUser(Integer id);
	
	//UserModel addUser(UserModel userModel);
	
	public UserModel saveInfo(UserModel userModel);

	public UserModel findByEmail(String email);

	public UserModel findUserById(Integer id);

	void addUser(UserModel userModel);

	public void saveSkill(UserModel userModel);
	
	public UserModel saveIntroduction(UserModel userModel);

	UserModel saveAmbition(UserModel userModel);
}
