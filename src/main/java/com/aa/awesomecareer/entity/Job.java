package com.aa.awesomecareer.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "job")
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "companyId")
	private Integer companyId;

	@Column(name = "jobTitle", length = 256)
	private String jobTitle;
	@Column(name = "jobTitle", length = 3000)
	private String discription;
	@Column(name = "endTime")
	@Temporal(value = TemporalType.TIMESTAMP)
	private String endTime;
	@Column(name = "author", length = 256)
	private String author;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "createdAt")
	private Date createdAt;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "updatedBy")
	private Date updatedBy;

	@OneToMany(mappedBy = "application")
	private List<Application> applications;

	@OneToMany(mappedBy = "bookmark")
	private List<Bookmark> bookmarks;

	@OneToMany(mappedBy = "voting")
	private List<Voting> votings;

	@OneToMany(mappedBy = "jobfield")
	private List<JobField> jobfields;

	@OneToMany(mappedBy = "jobtype")
	private List<JobType> jobtypes;

}
