package com.aa.awesomecareer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	
	@Column(name = "startYear")
	private String startYear;
	
	@Column(name = "startMonth")
	private String startMonth;
	
	@Column(name = "endYear")
	private String endYear;
	
	@Column(name = "endMonth")
	private String endMonth;
	
	@Column(name = "description", length = 3000)
	private String description;
	
	@Column(name = "currentlyWork")
	private boolean currentlyWork;
	
	@Column(name = "internship")
	private boolean internship;
	
	@ManyToOne
	@JoinColumn(name = "experience_id")
	private User user;
	
	public Experience() {

	}

	public Experience(Integer id, Integer userId, String companyName, String jobTitle, String startYear,
			String startMonth, String endYear, String endMonth, String description, boolean currentlyWork,
			boolean internship, User user) {
		super();
		this.id = id;
		this.userId = userId;
		this.companyName = companyName;
		this.jobTitle = jobTitle;
		this.startYear = startYear;
		this.startMonth = startMonth;
		this.endYear = endYear;
		this.endMonth = endMonth;
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

	public String getStartYear() {
		return startYear;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	public String getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}

	public String getEndYear() {
		return endYear;
	}

	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}

	public String getEndMonth() {
		return endMonth;
	}

	public void setEndMonth(String endMonth) {
		this.endMonth = endMonth;
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
