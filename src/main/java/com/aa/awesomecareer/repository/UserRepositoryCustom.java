package com.aa.awesomecareer.repository;

import com.aa.awesomecareer.entity.User;

public interface UserRepositoryCustom {
	
	User findByEmail(String email);
	
	User findByUserId(Integer userId);
	
	void deleteByUserId(Integer id);
	
	void saveSkillUser(User user);
}
