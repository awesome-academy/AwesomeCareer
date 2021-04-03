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
	private Integer jobTypeNameId;
	
	@ManyToOne
	@JoinColumn(name = "jobId")
	private Job job;
	
	@ManyToOne
	@JoinColumn(name = "jobTypeNameId")
	private JobTypeName jobTypeName;
	
	public JobType() {
		
	}

	public JobType(Integer id, Integer jobId, Integer jobTypeNameId, Job job, JobTypeName jobTypeName) {
		super();
		this.id = id;
		this.jobId = jobId;
		this.jobTypeNameId = jobTypeNameId;
		this.job = job;
		this.jobTypeName = jobTypeName;
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

	public Integer getJobTypeNameId() {
		return jobTypeNameId;
	}

	public void setJobTypeNameId(Integer jobTypeNameId) {
		this.jobTypeNameId = jobTypeNameId;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public JobTypeName getJobTypeName() {
		return jobTypeName;
	}

	public void setJobTypeName(JobTypeName jobTypeName) {
		this.jobTypeName = jobTypeName;
	}
	
	
}
