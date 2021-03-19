package com.aa.awesomecareer.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

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
		try {
			Optional<User> user = userRepository.findById(id);
			UserModel userModel = new UserModel();
			BeanUtils.copyProperties(user, userModel);
			return userModel;
		} catch (Exception e) {
			logger.error("An error occurred while fetching the user details from the database", e);
			return null;
		}
	}

//	@Transactional
//	@Override
//	public UserModel addUser(UserModel userModel) {
//		if(emailExists(userModel.getEmail())) {
//			logger.info("There is an account with that email address" +userModel.getEmail());
//		}
//		User condition = new User();
//		condition.setFullName(userModel.getFullName());
//		condition.setEmail(userModel.getEmail());
//		condition.setPassword(userModel.getPassword());
//		condition.setCompany(userModel.getCompany());
//		condition.setOccupationInterest(userModel.getOccupationInterest());
//		condition.setCountry(userModel.getCountry());
//		User user= userRepository.save(condition);
//		userModel = new UserModel();
//		BeanUtils.copyProperties(user, userModel);
//		
//		return userModel;
//	}
	private boolean emailExists(String email) {
		return userRepository.findByEmail(email) !=null;
	}
	
	public UserModel saveInfo(UserModel userModel) {
		logger.info("Save basic info in the database");
		User saveinfo = new User();
		saveinfo.setId(2);
		saveinfo.setGender(userModel.getGender());
		saveinfo.setBirthday(userModel.getBirthday());
		saveinfo.setRelationshipStatus(userModel.getRelationshipStatus());
		User user= userRepository.save(saveinfo);
		userModel = new UserModel();
		BeanUtils.copyProperties(user, userModel);
		return userModel;
	}

}
