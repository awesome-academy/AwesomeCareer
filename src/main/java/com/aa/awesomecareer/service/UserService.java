package com.aa.awesomecareer.service;

import java.util.List;

import com.aa.awesomecareer.entity.User;
import com.aa.awesomecareer.model.UserModel;

public interface UserService {
	public List<UserModel> findAll();
	
	public UserModel findUser(Integer id);
	
	//UserModel addUser(UserModel userModel);
	
	public UserModel saveInfo(UserModel userModel);

}
