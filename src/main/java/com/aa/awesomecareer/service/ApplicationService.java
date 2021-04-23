package com.aa.awesomecareer.service;

import java.util.List;

import com.aa.awesomecareer.model.ApplicationModel;
import com.aa.awesomecareer.model.UserModel;

public interface ApplicationService {

	ApplicationModel saveApplicationModel(ApplicationModel applicationModel);
	List<UserModel> findByJobId(Integer userId);
	public boolean existApplication(Integer userId, Integer jobId);
	List<ApplicationModel> findAllApplicant();
	Long findApplicantByJobId(Integer jobId);
	Long countApplicantByTime(Integer monthapply, Integer yearapply);
	
}
