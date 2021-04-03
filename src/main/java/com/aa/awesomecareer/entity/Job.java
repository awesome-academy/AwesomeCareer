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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "job")
public class Job extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "companyWebsite",length = 256)
	private String companyWebsite;
	
	@Column(name = "companyName", length = 256)
	private String companyName;

	@Column(name = "occupation", length = 256)
	private String occupation;
	
	@Column(name = "position", length = 3000)
	private String position;
	
	@Column(name = "type", length = 256)
	private String type;
	
	@Column(name = "jobTitle", length = 256)
	private String jobTitle;
	
	@Column(name = "address", length = 256)
	private String address;
	
	@Column(name = "introduction", length = 3000)
	private String introduction;
	
	@Column(name = "yourMission", length = 3000)
	private String yourMission;
	
	@Column(name = "positionDetail", length = 3000)
	private String positionDetail;
	
	@Column(name = "deadLine")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date deadLine;
	
	@OneToMany (mappedBy = "job")
	private List<JobType> jobTypes;

	public Job() {
	
	}
	
	public Job(Integer id, String companyWebsite, String companyName, String occupation, String position, String type,
			String jobTitle, String address, String introduction, String yourMission, String positionDetail,
			Date deadLine, List<JobType> jobTypes) {
		super();
		this.id = id;
		this.companyWebsite = companyWebsite;
		this.companyName = companyName;
		this.occupation = occupation;
		this.position = position;
		this.type = type;
		this.jobTitle = jobTitle;
		this.address = address;
		this.introduction = introduction;
		this.yourMission = yourMission;
		this.positionDetail = positionDetail;
		this.deadLine = deadLine;
		this.jobTypes = jobTypes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getYourMission() {
		return yourMission;
	}

	public void setYourMission(String yourMission) {
		this.yourMission = yourMission;
	}

	public String getPositionDetail() {
		return positionDetail;
	}

	public void setPositionDetail(String positionDetail) {
		this.positionDetail = positionDetail;
	}

	public Date getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}

	public List<JobType> getJobTypes() {
		return jobTypes;
	}

	public void setJobTypes(List<JobType> jobTypes) {
		this.jobTypes = jobTypes;
	}

}
