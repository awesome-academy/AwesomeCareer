package com.aa.awesomecareer.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aa.awesomecareer.entity.Skill;
import com.aa.awesomecareer.entity.SkillUser;
import com.aa.awesomecareer.entity.User;
import com.aa.awesomecareer.model.SkillModel;
import com.aa.awesomecareer.model.UserModel;
import com.aa.awesomecareer.repository.SkillRepository;
import com.aa.awesomecareer.repository.SkillUserRepository;
import com.aa.awesomecareer.repository.SkillUserRepositoryCustom;
import com.aa.awesomecareer.repository.UserRepository;
import com.aa.awesomecareer.service.UserService;

@Service
@Qualifier("userService")
public class UserServiceImp implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImp.class);

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SkillRepository skillRepository;
	
	@Autowired
	private SkillUserRepository skillUserRepository;
	
	@Autowired
	private SkillUserRepositoryCustom skillUserRepositoryCustom;

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

	@Override
	@Transactional
	public void addUser(UserModel userModel) {
		if (emailExists(userModel.getEmail())) {
			logger.info("There is an account with that email address" + userModel.getEmail());
		}
		try {
			User condition = new User();
			condition.setFullName(userModel.getFullName());
			condition.setEmail(userModel.getEmail());
			condition.setPassword(userModel.getPassword());
			condition.setCompany(userModel.getCompany());
			condition.setOccupationInterest(userModel.getOccupationInterest());
			condition.setCountry(userModel.getCountry());

			userRepository.save(condition);

		} catch (Exception e) {
			logger.error("An error occurred while adding user to the database");
		}
	}

	@Override
	@Transactional
	public void saveSkill(UserModel userModel) {
		try {
			System.out.println("kich thuoc" + userModel.getSkillIds().size());
		    List<Integer> ids = userModel.getSkillIds();
		    List<SkillUser> skillUsers = skillUserRepositoryCustom.findByUserId(userModel.getId());
		    for(SkillUser skillUser: skillUsers) {
		    	skillUserRepository.deleteById(skillUser.getId());
		    }
		   
		   for (Integer id : ids) {
			   System.out.println("Xem co id khong naof " +id);
			   SkillUser skillUser = new SkillUser();
			   skillUser.setSkillId(id);
			   skillUser.setUserId(userModel.getId());
			   skillUserRepository.save(skillUser);
		   }
		   
		} catch (Exception e) {
			logger.error("An error occurred while adding user to the database", e);
		}
	}

	private boolean emailExists(String email) {
		return userRepository.findByEmail(email) != null;
	}

	@Override
	@Transactional(readOnly = true)
	public UserModel findUserById(Integer id) {
		Optional<User> userOpt = userRepository.findById(id);
		if (!userOpt.isPresent()) {
			return null;
		}
		User user = userOpt.get();
		UserModel userModel = new UserModel();
		BeanUtils.copyProperties(user, userModel);
		Set<Skill> skills = user.getSkills();
		List<Integer> skillIds = new ArrayList<Integer>();
		for (Skill skill : skills) {
			skillIds.add(skill.getId());
		}
		userModel.setSkillIds(skillIds);

		return userModel;

	}

	@Override
	public UserModel saveIntroduction(UserModel userModel) {
		User user = new User();
		BeanUtils.copyProperties(userModel,user);
		User userNew =userRepository.save(user);
		UserModel userModelNew = new UserModel();
		BeanUtils.copyProperties(userNew, userModelNew);
		return userModelNew;
	}
	
	@Override
	public UserModel saveAmbition(UserModel userModel) {
		User user = new User();
		BeanUtils.copyProperties(userModel, user);
		User userNew = userRepository.save(user);
		UserModel userModelNew = new UserModel();
		BeanUtils.copyProperties(userNew, userModelNew);
		return userModelNew;
	}
	
	@Override
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
	
	@Override
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
