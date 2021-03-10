package com.aa.awesomecareer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "application")
public class Application {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "userId")
	private Integer userId;
	@Column(name = "jobId")
	private Integer jobId;

	@ManyToOne
	@JoinColumn(name = "id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Job job;

}
