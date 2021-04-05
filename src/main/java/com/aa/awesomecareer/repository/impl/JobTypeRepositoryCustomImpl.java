package com.aa.awesomecareer.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aa.awesomecareer.entity.Experience;
import com.aa.awesomecareer.entity.JobType;
import com.aa.awesomecareer.repository.ExperienceRepositoryCustom;
import com.aa.awesomecareer.repository.JobTypeRepositoryCustom;

@Repository
public class JobTypeRepositoryCustomImpl implements JobTypeRepositoryCustom {
	
	@Autowired
	private EntityManager entityManager;
	
	public List<JobType> findByJobId(Integer jobId){
		TypedQuery<JobType> query = entityManager.createQuery("FROM JobType jobtype WHERE jobtype.jobId = :jobId", JobType.class);
		query.setParameter("jobId", jobId);
		return query.getResultList();
	}
}
