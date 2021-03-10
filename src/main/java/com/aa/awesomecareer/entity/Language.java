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
@Table(name = "language")
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "language",length = 256)
	private String language;
	@Column(name = "proficiency",length = 256)
	private String proficiency;
	@Column(name = "userId")
	private Integer userId;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private User user;
	

}
