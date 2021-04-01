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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@SuppressWarnings("serial")
@Entity
@Table(name = "education")
public class Education {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "userId")
	private Integer userId;

	@Column(name = "school", length = 256)
	private String school;
	
	@Column(name = "major", length = 256)
	private String major;
	
	@Column(name = "description", length = 3000)
	private String description;
	
	@Column(name = "graduation")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date graduation;
	
	@ManyToOne
	@JoinColumn(name = "userId",insertable = false, updatable = false)
	private User user;

	public Education() {
		
	}

	public Education(Integer id, Integer userId, String school, String major, String description, Date graduation,
			User user) {
		super();
		this.id = id;
		this.userId = userId;
		this.school = school;
		this.major = major;
		this.description = description;
		this.graduation = graduation;
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

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getGraduation() {
		return graduation;
	}

	public void setGraduation(Date graduation) {
		this.graduation = graduation;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
