package com.aa.awesomecareer.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.aa.awesomecareer.entity.Application;
import com.aa.awesomecareer.entity.Job;
import com.aa.awesomecareer.entity.User;
import com.aa.awesomecareer.repository.ApplicationRepository;
import com.aa.awesomecareer.repository.ApplicationRepositoryCustom;

public class ApplicationRepositoryCustomImpl implements ApplicationRepositoryCustom {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Application> findApplicationByJobId(Integer jobId) {
		TypedQuery<Application> query = entityManager.createQuery("FROM Application application WHERE application.jobId = :jobId", Application.class);
		query.setParameter("jobId", jobId);
		return query.getResultList();
	}
	
	@Override
	public boolean findApplication(Integer userId,Integer jobId) {
		TypedQuery<Long> query = entityManager
				.createQuery("SELECT COUNT(*) FROM Application application WHERE "
						+ "application.jobId = :jobId AND application.userId = :userId", Long.class);
		query.setParameter("jobId", jobId);
		query.setParameter("userId", userId);
		return query.getSingleResult()>0;
	}
	
}
