package com.aa.awesomecareer.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aa.awesomecareer.entity.SkillUser;
import com.aa.awesomecareer.entity.User;
import com.aa.awesomecareer.repository.SkillUserRepositoryCustom;
import com.aa.awesomecareer.repository.UserRepositoryCustom;

@Repository
public class SkillUserRepositoryCustomImpl implements SkillUserRepositoryCustom {

	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	public List<SkillUser> findByUserId(Integer userId) {
		TypedQuery<SkillUser> query = entityManager.createQuery("FROM SkillUser skilluser WHERE skilluser.userId = :userId", SkillUser.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}

}
