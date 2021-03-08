package com.aa.awesomecareer.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.aa.awesomecareer.entity.User;
import com.aa.awesomecareer.model.UserModel;
import com.aa.awesomecareer.repository.UserRepository;
import com.aa.awesomecareer.service.UserService;

@Service
@Qualifier("userService")
public class UserServiceImp implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImp.class);

	@Autowired
	private UserRepository userRepository;

	private UserServiceImp() {
	}

	public List<UserModel> findAll() {
		logger.info("Fetching all users in the database");
		try {
			List<User> userList = userRepository.findAll();
			return userList.stream().map(user -> {
				UserModel userModel = new UserModel();
				BeanUtils.copyProperties(user, userModel);
				return userModel;
			}).collect(Collectors.toList());
		} catch (Exception e) {
			logger.error("An error occurred while fetching all users from the database", e);
		}
		return null;
	}

	public UserModel findByEmail(String email) {
		logger.info("Fetching user by email in the database");
		try {
			User user = userRepository.findByEmail(email);
			UserModel userModel = new UserModel();
			BeanUtils.copyProperties(user, userModel);
			return userModel;
		} catch (Exception e) {
			logger.error("An error occurred while fetching user by email from the database", e);
		}
		return null;
	}

}
