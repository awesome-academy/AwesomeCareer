package com.aa.awesomecareer.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.aa.awesomecareer.model.JobModel;


public interface JobService {
      
	void saveJobModel(JobModel jobModel);
	JobModel showJobDetail(Integer id);
	List<JobModel> findAllJob();
}
