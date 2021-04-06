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
import com.aa.awesomecareer.model.JobModel;
import com.aa.awesomecareer.model.TypeModel;
import com.aa.awesomecareer.repository.JobRepository;
import com.aa.awesomecareer.repository.JobTypeRepository;
import com.aa.awesomecareer.repository.TypeRepository;
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

	@Override
	public void saveJobModel(JobModel jobModel,String url) {
		try {
		Job job = new Job();
		BeanUtils.copyProperties(jobModel, job);
        job.setImage(url);
		Job jobSave = jobRepository.save(job);
		Integer[] typeIds = jobModel.getTypeIds();
		
		for(Integer typeId : typeIds) {
			JobType jobType = new JobType();
			jobType.setJobId(jobSave.getId());
			jobType.setTypeId(typeId);
			System.out.println("Xem luu jobtype chua +" + jobType.getJobId() +"+"+jobType.getTypeId());
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
		JobModel jobModel = new JobModel();
		BeanUtils.copyProperties(job.get(), jobModel);
		List<JobType> jobTypes = jobTypeRepository.findByJobId(id);
		List<TypeModel> typeModels = new ArrayList<>();
		for(JobType jobType : jobTypes) {
			Optional<Type> type = typeRepository.findById(jobType.getTypeId());
			TypeModel typeModel = new TypeModel();
			BeanUtils.copyProperties(type.get(),  typeModel);
			typeModels.add(typeModel);
		}
		jobModel.setTypeModels(typeModels);
		jobModel.setUrl(job.get().getImage());
		return jobModel;
	}
	catch(Exception e) {
		logger.error("An error occurred while fetching the job from database",e);
		return null;
	}
	}
}
