package com.aa.awesomecareer.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aa.awesomecareer.entity.Job;

public interface JobRepository extends JpaRepository<Job, Integer>,JobRepositoryCustom{

}
