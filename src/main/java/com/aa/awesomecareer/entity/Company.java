package com.aa.awesomecareer.entity;

import java.util.Date;
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
@Table(name = "company")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name", length = 256)
	private String name;
	@Column(name = "address", length = 256)
	private String address;
	@Column(name = "website", length = 128)
	private String website;
	@Column(name = "foundedTime")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date foundedTime;
	@Column(name = "foundedBy", length = 256)
	private String foundedBy;
	@Column(name = "totalMember")
	private Integer totalMember;
	@Column(name = "image", length = 256)
	private String image;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "createdAt")
	private Date createdAt;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "updatedBy")
	private Date updatedBy;

}
