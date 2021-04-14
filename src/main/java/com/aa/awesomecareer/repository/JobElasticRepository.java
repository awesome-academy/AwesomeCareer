package com.aa.awesomecareer.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.aa.awesomecareer.model.JobElasticModel;

public interface JobElasticRepository extends ElasticsearchRepository<JobElasticModel, Integer> {
	
	List<JobElasticModel> findByJobTitle(String text);

}
