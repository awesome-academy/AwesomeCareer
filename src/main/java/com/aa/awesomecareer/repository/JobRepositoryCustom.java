package com.aa.awesomecareer.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.aa.awesomecareer.entity.Job;

public interface JobRepositoryCustom{
        List<Job> findByUserId(Integer id);
		Long findJobPostByUserId(Integer userId);
		List<Job> findJobByKeyword(String keyword);
}
