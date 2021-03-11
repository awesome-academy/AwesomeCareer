package com.aa.awesomecareer.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.aa.awesomecareer.entity.User;
import com.aa.awesomecareer.model.UserModel;

public interface UserService extends UserDetailsService, PersistentTokenRepository {
	public List<UserModel> findAll();
	public UserModel findByEmail(String email);
	UserModel addUser(UserModel userModel);

}
