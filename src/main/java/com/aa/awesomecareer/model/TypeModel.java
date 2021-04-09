package com.aa.awesomecareer.model;

import java.util.List;

import com.aa.awesomecareer.entity.JobType;

public class TypeModel {

	private Integer id;
	private String name;
	
	private List<JobType> jobTypes;
	
	public TypeModel() {
		
	}

	public TypeModel(Integer id, String name, List<JobType> jobTypes) {
		this.id = id;
		this.name = name;
		this.jobTypes = jobTypes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<JobType> getJobTypes() {
		return jobTypes;
	}

	public void setJobTypes(List<JobType> jobTypes) {
		this.jobTypes = jobTypes;
	}
}
