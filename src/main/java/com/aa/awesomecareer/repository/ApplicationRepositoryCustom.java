package com.aa.awesomecareer.repository;

import java.util.List;

import com.aa.awesomecareer.entity.Application;

public interface ApplicationRepositoryCustom {
      List<Application> findApplicationByJobId (Integer id);

	boolean findApplication(Integer userId, Integer jobId);

	Long findApplicantByJobId(Integer jobId);
	
	Long countApplicantByTime(Integer monthapply, Integer yearapply);
}
