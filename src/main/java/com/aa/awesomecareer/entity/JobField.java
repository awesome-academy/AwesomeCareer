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
@Table(name = "jobfield")
public class JobField extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "jobId")
	private Integer jobId;
	@Column(name = "fieldId")
	private Integer fieldId;

	

//	@ManyToOne
//	@JoinColumn(name = "id")
//	private Job job;
//
//	@ManyToOne
//	@JoinColumn(name = "id")
//	private Field field;

}
