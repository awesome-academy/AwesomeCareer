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
@Table(name = "profile")
public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "currentOccupation", length = 256)
	private String currentOccupation;
	@Column(name = "location", length = 256)
	private String location;
	@Column(name = "tagLine", length = 256)
	private String tagLine;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "createdAt")
	private Date createdAt;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "updatedBy")
	private Date updatedBy;
//
//	@ManyToOne
//	@JoinColumn(name = "id")
//	private User user;

}
