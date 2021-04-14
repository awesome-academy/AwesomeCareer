package com.aa.awesomecareer.model;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "jobelasticmodel") 
public class JobElasticModel {
	
	private Integer id;
	private String jobTitle;
	
	private UserElasticModel userElasticModel;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public UserElasticModel getUserElasticModel() {
		return userElasticModel;
	}
	public void setUserElasticModel(UserElasticModel userElasticModel) {
		this.userElasticModel = userElasticModel;
	}

}
