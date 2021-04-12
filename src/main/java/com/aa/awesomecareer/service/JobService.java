package com.aa.awesomecareer.service;

import java.util.List;

import com.aa.awesomecareer.model.JobModel;


public interface JobService {
      
	JobModel showJobDetail(Integer id);
	List<JobModel> findAllJob();
	void saveJobModel(JobModel jobModel, String ImageUrl);
	List<JobModel> findJobByUserId(Integer userId);
	Long findJobPostByUserId(Integer userId);
	List<JobModel> findAllJobSearch(String keyword);
}
