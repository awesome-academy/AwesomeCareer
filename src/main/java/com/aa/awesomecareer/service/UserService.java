package com.aa.awesomecareer.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

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

	public void updateImage(UserModel userModel, String url);

	void updateResetPasswordToken(String token, String email) throws EntityNotFoundException;

	UserModel findUserByPasswordForgotToken(String token);

	void updateNewPassword(String token, String newPassword);

}
