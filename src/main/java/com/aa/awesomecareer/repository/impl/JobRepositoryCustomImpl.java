package com.aa.awesomecareer.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.aa.awesomecareer.entity.Job;
import com.aa.awesomecareer.repository.JobRepositoryCustom;

public class JobRepositoryCustomImpl implements JobRepositoryCustom {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Job> findByUserId(Integer userId) {
		TypedQuery<Job> query = entityManager.createQuery("FROM Job job WHERE job.userId = :userId", Job.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}
	
	@Override
	public Long findJobPostByUserId( Integer userId) {
		
		TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(*) FROM Job job WHERE job.userId = :userId", Long.class);
		query.setParameter("userId", userId);
		return query.getSingleResult();
		
	}
	
	@Override
	public List<Job> findJobByKeyword(String keyword) {
		TypedQuery<Job> query = entityManager.createQuery("FROM Job job WHERE position LIKE :keyword", Job.class);
		query.setParameter("keyword", '%'+keyword+'%');
		return query.getResultList();
	}


}
