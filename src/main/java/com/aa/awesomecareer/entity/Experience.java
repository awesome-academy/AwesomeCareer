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

import com.aa.awesomecareer.model.BaseModel;

@SuppressWarnings("serial")
@Entity
@Table(name = "experience")
public class Experience extends BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "userId")
	private Integer userId;

	@Column(name = "companyName", length = 256)
	private String companyName;
	@Column(name = "jobTitle", length = 256)
	private String jobTitle;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "startTime")
	private Date startTime;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "endTime")
	private Date endTime;
	
	@Column(name = "description", length = 3000)
	private String description;
	
	@Column(name = "currentlyWork")
	private boolean currentlyWork;
	
	@Column(name = "internship")
	private boolean internship;
	
	@ManyToOne
	@JoinColumn(name = "userId",insertable = false, updatable = false)
	private User user;
	
	public Experience() {

	}

	public Experience(Integer id, Integer userId, String companyName, String jobTitle, Date startTime, Date endTime,
			String description, boolean currentlyWork, boolean internship, User user) {
		super();
		this.id = id;
		this.userId = userId;
		this.companyName = companyName;
		this.jobTitle = jobTitle;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
		this.currentlyWork = currentlyWork;
		this.internship = internship;
		this.user = user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCurrentlyWork() {
		return currentlyWork;
	}

	public void setCurrentlyWork(boolean currentlyWork) {
		this.currentlyWork = currentlyWork;
	}

	public boolean isInternship() {
		return internship;
	}

	public void setInternship(boolean internship) {
		this.internship = internship;
	}
	
	

}
