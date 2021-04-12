package com.aa.awesomecareer.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "application")
public class Application extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "userId")
	private Integer userId;

	@Column(name = "jobId")
	private Integer jobId;

	@Column(name="fileUrl")
	private String fileUrl;
	
	@Column(name="status")
	private Integer status;


	@ManyToOne
	@JoinColumn(name = "userId",insertable = false, updatable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "jobId",insertable = false, updatable = false)
	private Job job;
	
	public Application() {
		super();
	}

	public Application(Integer id, Integer userId, Integer jobId, String fileUrl, User user, Job job) {
		super();
		this.id = id;
		this.userId = userId;
		this.jobId = jobId;
		this.fileUrl = fileUrl;
		this.user = user;
		this.job = job;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
