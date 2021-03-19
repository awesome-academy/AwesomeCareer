package com.aa.awesomecareer.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "experience")
public class Experience {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "companyName", length = 256)
	private String companyName;
	@Column(name = "jobTitle", length = 256)
	private String jobTitle;
	
	@Column(name = "startTime")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date startTime;
	
	@Column(name = "endTime")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date endTime;
	
	@Column(name = "description", length = 3000)
	private String description;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "createdAt")
	private Date createdAt;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "updatedBy")
	private Date updatedBy;
}
