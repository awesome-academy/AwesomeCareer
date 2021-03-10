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
@Table(name = "certificate")
public class Certificate {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "userId",length = 256)
	private Integer userId;
	@Column(name = "title",length = 256)
	private String title;
	@Column(name = "issuedTime")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date issuedTime;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private User user;

}
