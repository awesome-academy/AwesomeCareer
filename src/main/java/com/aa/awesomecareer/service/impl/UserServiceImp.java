package com.aa.awesomecareer.service.impl;

import java.util.List;
import java.util.Optional;
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

	public UserServiceImp() {
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

	public UserModel findUser(Integer id) {
		logger.info("Tim kiem user theo id trong co so du lieu");
		System.out.println("findUser");
		try {
			Optional<User> user = userRepository.findById(id);
			if (user.isPresent()) {
				UserModel userModel = new UserModel();
				BeanUtils.copyProperties(user.get(), userModel);
				return userModel;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("An error occurred while fetching the user details from the database", e);
			return null;
		}
	}

	public UserModel saveInfo(UserModel userModel) {
		logger.info("Save basic info in the database");
		Optional<User> saveinfo = userRepository.findById(3);
		User user = saveinfo.get();
		user.setGender(userModel.getGender());
		user.setBirthday(userModel.getBirthday());
		user.setRelationshipStatus(userModel.getRelationshipStatus());
		User user1 = userRepository.save(user);
		userModel = new UserModel();
		BeanUtils.copyProperties(user1, userModel);
		return userModel;
	}

}
