package com.aa.awesomecareer.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.aa.awesomecareer.entity.User;
import com.aa.awesomecareer.repository.UserRepositoryCustom;

public class UserRepositoryCustomImpl implements UserRepositoryCustom {

	@Autowired
	private EntityManager entityManager;

//	@Override
//	public User findByEmail(String email) {
//		TypedQuery<User> query = entityManager.createQuery("FROM Users user WHERE users.email = :email", User.class);
//		query.setParameter("email", email);
//		return query.getSingleResult();
//	}

}
