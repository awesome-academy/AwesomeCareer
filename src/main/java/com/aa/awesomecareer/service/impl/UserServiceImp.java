package com.aa.awesomecareer.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.stereotype.Service;

import com.aa.awesomecareer.configuration.MyUserDetails;
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
	
	@Autowired
	private PasswordEncoder passwordEncoder;

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

	@Transactional
	@Override
	public UserModel addUser(UserModel userModel) {
		if(emailExists(userModel.getEmail())) {
			logger.info("There is an account with that email address" +userModel.getEmail());
		}
		User condition = new User();
		condition.setFullName(userModel.getFullName());
		condition.setEmail(userModel.getEmail());
		condition.setPassword(passwordEncoder.encode(userModel.getPassword()));
		condition.setCompany(userModel.getCompany());
		condition.setOccupationInterest(userModel.getOccupationInterest());
		condition.setCountry(userModel.getCountry());
		User user= userRepository.save(condition);
		userModel = new UserModel();
		BeanUtils.copyProperties(user, userModel);
		
		return userModel;
	}
	private boolean emailExists(String email) {
		return userRepository.findByEmail(email) !=null;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		return new MyUserDetails(user);
	}
	

	@Override
	public void createNewToken(PersistentRememberMeToken token) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateToken(String series, String tokenValue, Date lastUsed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PersistentRememberMeToken getTokenForSeries(String seriesId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeUserTokens(String username) {
		// TODO Auto-generated method stub
		
	}

}
