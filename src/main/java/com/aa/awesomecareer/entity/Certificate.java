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
public class Certificate extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "userId")
	private Integer userId;
	@Column(name = "title", length = 256)
	private String title;
	@Column(name = "issuedTime")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date issuedTime;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getIssuedTime() {
		return issuedTime;
	}

	public void setIssuedTime(Date issuedTime) {
		this.issuedTime = issuedTime;
	}

//	@ManyToOne
//	@JoinColumn(name = "id")
//	private User user;

}
