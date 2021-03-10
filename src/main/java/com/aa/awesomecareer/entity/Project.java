package com.aa.awesomecareer.entity;

import java.util.Date;
import java.util.List;

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
@Table(name = "project")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "name",length = 256)
	private String title;
	@Column(name = "name",length = 256)
	private String link;
	@Column(name = "startDate")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date startDate;
	@Column(name = "endDate")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date endDate;
	@Column(name = "name",length = 3000)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private User user;
}
