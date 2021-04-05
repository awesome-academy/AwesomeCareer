package com.aa.awesomecareer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="jobtype")
public class JobType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer jobId;
	private Integer typeId;
	
	@ManyToOne
	@JoinColumn(name = "jobId",insertable = false, updatable = false)
	private Job job;
	
	@ManyToOne
	@JoinColumn(name = "typeId",insertable = false, updatable = false)
	private Type type;
	
	public JobType() {
		
	}
	
	public JobType(Integer id, Integer jobId, Integer typeId, Job job, Type type) {
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


	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}
