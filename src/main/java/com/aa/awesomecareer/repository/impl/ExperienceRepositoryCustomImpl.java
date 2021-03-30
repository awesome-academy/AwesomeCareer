package com.aa.awesomecareer.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aa.awesomecareer.entity.Experience;
import com.aa.awesomecareer.repository.ExperienceRepositoryCustom;

@Repository
public class ExperienceRepositoryCustomImpl implements ExperienceRepositoryCustom {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Experience> findAllById(Integer userId) {
		TypedQuery<Experience> query = entityManager.createQuery("FROM Experience experience WHERE experience.userId = :userId", Experience.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}

}
