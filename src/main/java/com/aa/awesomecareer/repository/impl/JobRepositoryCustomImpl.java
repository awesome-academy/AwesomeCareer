package com.aa.awesomecareer.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aa.awesomecareer.entity.Job;
import com.aa.awesomecareer.entity.SkillUser;
import com.aa.awesomecareer.repository.JobRepositoryCustom;

@Repository
public class JobRepositoryCustomImpl implements JobRepositoryCustom {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Job> findJobByKeyword(String keyword) {
		TypedQuery<Job> query = entityManager.createQuery("FROM Job job WHERE position LIKE :keyword", Job.class);
		query.setParameter("keyword", '%'+keyword+'%');
		return query.getResultList();
	}

}
