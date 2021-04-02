package com.aa.awesomecareer.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aa.awesomecareer.entity.Education;
import com.aa.awesomecareer.repository.EducationRepositoryCustom;

@Repository
public class EducationRepositoryCustomImpl implements EducationRepositoryCustom {

		@Autowired
		private EntityManager entityManager;
		
		@Override
		 public List<Education> findByUserId(Integer userId){
			TypedQuery<Education> query = entityManager.createQuery("FROM Education education WHERE education.userId = :userId", Education.class);
			query.setParameter("userId", userId);
			return query.getResultList();
	
	}

}
