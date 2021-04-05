package com.aa.awesomecareer.model;

import com.aa.awesomecareer.entity.Job;
import com.aa.awesomecareer.entity.Type;

public class JobTypeModel {
	
	private Integer id;
	private Integer jobId;
	private Integer typeId;
	
	private Job job;
	private Type type;
	
	public JobTypeModel() {
		
	}

	public JobTypeModel(Integer id, Integer jobId, Integer typeId, Job job, Type type) {
		super();
		this.id = id;
		this.jobId = jobId;
		this.typeId = typeId;
		this.job = job;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
