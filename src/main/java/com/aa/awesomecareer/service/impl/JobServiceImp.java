package com.aa.awesomecareer.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.aa.awesomecareer.entity.Job;
import com.aa.awesomecareer.entity.JobType;
import com.aa.awesomecareer.entity.Type;
import com.aa.awesomecareer.entity.User;
import com.aa.awesomecareer.model.JobModel;
import com.aa.awesomecareer.model.TypeModel;
import com.aa.awesomecareer.model.UserModel;
import com.aa.awesomecareer.repository.ApplicationRepository;
import com.aa.awesomecareer.repository.JobRepository;
import com.aa.awesomecareer.repository.JobTypeRepository;
import com.aa.awesomecareer.repository.TypeRepository;
import com.aa.awesomecareer.repository.UserRepository;
import com.aa.awesomecareer.service.JobService;

@Service
public class JobServiceImp implements JobService {
	
	private static final Logger logger = LoggerFactory.getLogger(JobServiceImp.class);
	
	@Autowired
	JobTypeRepository jobTypeRepository;
	
	@Autowired
	JobRepository jobRepository;
	
	@Autowired
	TypeRepository typeRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ApplicationRepository applicationRepository;

	@Override
	public void saveJobModel(JobModel jobModel,String imageUrl) {
		try {
		Job job = new Job();
		BeanUtils.copyProperties(jobModel, job);
        job.setImageUrl(imageUrl);;
		Job jobSave = jobRepository.save(job);
		Integer[] typeIds = jobModel.getTypeIds();
		
		for(Integer typeId : typeIds) {
			JobType jobType = new JobType();
			jobType.setJobId(jobSave.getId());
			jobType.setTypeId(typeId);
			jobTypeRepository.save(jobType);
		}
		
	}catch(Exception e) {
		logger.error("An error occurred while save the job in database",e);
	}
	}
	@Override
	public List<JobModel> findAllJob() {
		try {
	     List<Job> jobs = jobRepository.findAll();
	     List<JobModel> jobModels = new ArrayList<>();
	     for(Job job : jobs) {
	    	 JobModel jobModel = new JobModel();
	    	 BeanUtils.copyProperties(job,jobModel);
	    	 jobModel.setImageUrl(job.getImageUrl());
	    	 String shortDescription = jobModel.getDescription().substring(0,100);
	    	 jobModel.setShortDescription(shortDescription);
	    	 jobModels.add(jobModel);
	     }
	     return jobModels;
	} catch (Exception e) {
		logger.error("An error occurred while fetching the job from database",e);
		return null;
	}
}


	@Override
	public JobModel showJobDetail(Integer id) {
		try {
		Optional<Job> job = jobRepository.findById(id);
		Optional<User> user = userRepository.findById(job.get().getUserId());
		job.get().setUser(user.get());
		UserModel userModel = new UserModel();
		BeanUtils.copyProperties(user.get(), userModel);
		JobModel jobModel = new JobModel();
		BeanUtils.copyProperties(job.get(), jobModel);
		jobModel.setUserModel(userModel);

		List<JobType> jobTypes = jobTypeRepository.findByJobId(id);
		List<TypeModel> typeModels = new ArrayList<>();
		for(JobType jobType : jobTypes) {
			Optional<Type> type = typeRepository.findById(jobType.getTypeId());
			TypeModel typeModel = new TypeModel();
			BeanUtils.copyProperties(type.get(),  typeModel);
			typeModels.add(typeModel);
		}
		jobModel.setTypeModels(typeModels);
		System.out.println("Xem kich thuoc jobModel la "+ jobModel.getTypeModels().size());
		jobModel.setImageUrl(job.get().getImageUrl());
		return jobModel;
	}
	catch(Exception e) {
		logger.error("An error occurred while fetching the job from database",e);
		return null;
	}
	}
	@Override
	public List<JobModel> findJobByUserId(Integer userId) {
		logger.info("Find all job from database by UserId");
	
		try {
		List<Job> jobs = jobRepository.findByUserId(userId);
		List<JobModel> jobModels = new ArrayList<>();
		for(Job job : jobs) {
			JobModel jobModel = new JobModel();
			BeanUtils.copyProperties(job,jobModel);
			System.out.println("ten job" + jobModel.getJobTitle());
			Long qtyApplycantByJobId = applicationRepository.findApplicantByJobId(job.getId());
	    	 System.out.println("xem ket qua qty cua applycant nao" +qtyApplycantByJobId);
	    	 jobModel.setQtyApplycantByJobId(qtyApplycantByJobId);
			jobModels.add(jobModel);
		}
		return jobModels;
	} catch(Exception e) {
		logger.error("An error occurred while fetching the job from database",e);
		return null;
	}
	}
	
	@Override
	public Long findJobPostByUserId(Integer userId) {
		Long quantityJob = jobRepository.findJobPostByUserId(userId);
		return quantityJob;
		
	}
	
	@Override
	public List<JobModel> findAllJobSearch(String keyword) {
		logger.error("Find all job from database by keyword");
		try {
		List<Job> jobs = jobRepository.findJobByKeyword(keyword);
		List<JobModel> jobModels = new ArrayList<>();
		for(Job job : jobs) {
			JobModel jobModel = new JobModel();
			BeanUtils.copyProperties(job,  jobModel);
			jobModels.add(jobModel);
		}
		
		return jobModels;
	}catch (Exception e) {
		 logger.error("An error occurred while find all jobs from database by keyword",e);
		 return null;
	}
	}
}
