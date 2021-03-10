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
@Table(name = "jobfield")
public class JobField {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "jobId")
	private Integer jobId;
	@Column(name = "fieldId")
	private Integer fieldId;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Job job;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Field field;

}
