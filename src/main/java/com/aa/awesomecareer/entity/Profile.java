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
@Table(name = "profileinfo")
public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "currentOccupation",length = 256)
	private String currentOccupation;
	@Column(name = "location",length = 256)
	private String location;
	@Column(name = "tagName",length = 256)
	private String tagName;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private User user;

}
