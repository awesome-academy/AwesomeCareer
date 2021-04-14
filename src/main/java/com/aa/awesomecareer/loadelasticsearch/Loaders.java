package com.aa.awesomecareer.loadelasticsearch;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aa.awesomecareer.entity.Job;
import com.aa.awesomecareer.entity.User;
import com.aa.awesomecareer.model.JobElasticModel;
import com.aa.awesomecareer.model.UserElasticModel;
import com.aa.awesomecareer.repository.JobElasticRepository;
import com.aa.awesomecareer.repository.JobRepository;
import com.aa.awesomecareer.repository.UserRepository;


@Service
public class Loaders {


//	@Autowired
//    ElasticsearchTemplate elasticsearchTemplate;
   
	@Autowired
    ElasticsearchOperations operations;

    @Autowired
    JobElasticRepository jobElasticRepository;
    
    @Autowired
    JobRepository jobRepository;
    
    @Autowired
    UserRepository userRepository;

//    public void createIndex() {
//    	elasticsearchTemplate.indexOps(JobElasticModel.class).create();
//    }
    
    @PostConstruct
    @Transactional
    public void create() {
    	for (JobElasticModel jobElasticModel : getData()) {
    		 operations.putMapping(JobElasticModel.class);
    		jobElasticRepository.save(jobElasticModel);
    	}
    }
    private List<JobElasticModel> getData() {
        List<Job> jobs = jobRepository.findAll();
        System.out.println("Kiem tra elastic " + jobs.size());
        List<JobElasticModel> jobElasticModels = new ArrayList<>();
        for (Job job : jobs) {
        	JobElasticModel jobElasticModel = new JobElasticModel();
        	BeanUtils.copyProperties(job, jobElasticModel);
        	
        	Optional<User> user = userRepository.findById(job.getUserId());
        	UserElasticModel userElasticModel = new UserElasticModel();
        	BeanUtils.copyProperties(user.get(), userElasticModel);
        	jobElasticModel.setUserElasticModel(userElasticModel);
        	jobElasticModels.add(jobElasticModel);
        	
        }
        System.out.println("Kiem tra elastic " + jobElasticModels.size());
        return jobElasticModels;
    }
}
