package com.aa.awesomecareer.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aa.awesomecareer.entity.Application;
import com.aa.awesomecareer.entity.Job;
import com.aa.awesomecareer.entity.User;
import com.aa.awesomecareer.model.ApplicationModel;
import com.aa.awesomecareer.model.UserModel;
import com.aa.awesomecareer.repository.ApplicationRepository;
import com.aa.awesomecareer.repository.JobRepository;
import com.aa.awesomecareer.repository.UserRepository;
import com.aa.awesomecareer.service.ApplicationService;
import com.aa.awesomecareer.util.Constants.Status;

@Service
public class ApplicationServiceImp implements ApplicationService {
	private static final Logger logger = LoggerFactory.getLogger(ExperienceServiceImp.class);
	@Autowired
	ApplicationRepository applicationRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	JobRepository jobRepository;

	@Override
	public ApplicationModel saveApplicationModel(ApplicationModel applicationModel) {
		try {
	    Application application = new Application();
	    BeanUtils.copyProperties(applicationModel, application);
		Application applicationSave = applicationRepository.save(application);
		ApplicationModel applicationModelSave = new ApplicationModel();
		BeanUtils.copyProperties(applicationSave, applicationModelSave);
		return applicationModelSave;
		
	}catch(Exception e) {
		logger.error("save Apllication error", e);
		return null;
	}
	}
	@Override
	public List<UserModel> findByJobId(Integer jobId) {
		try {
		List<Application> applications = applicationRepository.findApplicationByJobId(jobId);
		List<UserModel> userModels = new ArrayList<>();
		for(Application application : applications) {
			Optional<User> user = userRepository.findById(application.getUserId());
			UserModel userModel = new UserModel();
			BeanUtils.copyProperties(user.get(),userModel);
			userModel.setCvUrl(application.getFileUrl());
			System.out.println("Vao day chua " + userModel.fullName);
			userModels.add(userModel);
		}
		return userModels;
	}catch(Exception e) {
		logger.error("find user by job Id error", e);
		return null;
	}
	}
	public boolean existApplication(Integer userId, Integer jobId) {
		if (applicationRepository.findApplication(userId, jobId)) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public List<ApplicationModel> findAllApplicant() {
		try {
		List<Application> applications = applicationRepository.findAll();
	    List<ApplicationModel> applicationModels = new ArrayList<>();
		for (Application application : applications) {
			ApplicationModel applicationModel = new ApplicationModel();
			System.out.println("xem chi so application" +application.getStatus());
			BeanUtils.copyProperties(application, applicationModel);
			Optional<User> user = userRepository.findById(application.getUserId());
			applicationModel.setApplicantName(user.get().getFullName());
			Optional<Job> job = jobRepository.findById(application.getJobId());
			applicationModel.setJobName(job.get().getJobTitle());
			applicationModel.setStatus(Status.getStatusByValue(application.getStatus()));
		    applicationModels.add(applicationModel);
		}
		return applicationModels;
	}catch(Exception e) {
		logger.error("There is no applicant in database", e);
		return null;
	}
	}
	
	@Override
	public Long findApplicantByJobId(Integer jobId) {
		Long qtyApplicantByJob = applicationRepository.findApplicantByJobId(jobId);
		return qtyApplicantByJob;
	}
	
	
}
