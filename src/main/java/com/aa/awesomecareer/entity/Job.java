package com.aa.awesomecareer.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "job")
public class Job extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "jobTitle", length = 256)
	private String jobTitle;
	
	@Column(name = "companyWebsite",length = 256)
	private String companyWebsite;
	
	@Column(name = "companyName", length = 256)
	private String companyName;
	
	@Column(name = "address", length = 256)
	private String address;

	@Column(name = "fieldName")
	private String fieldName;
	
	@Column(name = "position", length = 256)
	private String position;
	
	@Column(name = "introduction", length = 3000)
	private String introduction;
	
	@Column(name = "description", length = 3000)
	private String description;
	
	@Column(name = "requirement", length = 3000)
	private String requirement;
	
	@Column(name = "reason", length = 3000)
	private String reason;
	
	@Column(name = "imageUrl", length = 256)
	private String imageUrl;

	@Column(name = "userId",insertable = false, updatable = false)
	private Integer userId;
	
	@ManyToOne
	@JoinColumn(name = "userId",insertable = false, updatable = false)
	private User user;
	
	@Column(name = "deadLine")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date deadLine;
	
	@OneToMany (mappedBy = "job")
	private List<JobType> jobTypes;
	
	@Column(name = "fieldId")
	private Integer fieldId;
	
	@OneToMany( mappedBy = "job")
	private List<Application> applications;
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(
			name="jobtype",
			joinColumns = @JoinColumn(name="jobId"),
			inverseJoinColumns = @JoinColumn(name="typeId")
			)
    private Set<Type> types = new HashSet<>();
	
	@OneToOne
    @JoinColumn(name = "fieldId",insertable = false, updatable = false)
	private Field field;
	
	public Job() {
		
	}
	
	public Job(Integer id, String jobTitle, String companyWebsite, String companyName, String address, String fieldName,
			String position, String introduction, String description, String requirement, String reason,
			String imageUrl, Integer userId, User user, Date deadLine, List<JobType> jobTypes, Integer fieldId,
			List<Application> applications, Set<Type> types, Field field) {
		super();
		this.id = id;
		this.jobTitle = jobTitle;
		this.companyWebsite = companyWebsite;
		this.companyName = companyName;
		this.address = address;
		this.fieldName = fieldName;
		this.position = position;
		this.introduction = introduction;
		this.description = description;
		this.requirement = requirement;
		this.reason = reason;
		this.imageUrl = imageUrl;
		this.userId = userId;
		this.user = user;
		this.deadLine = deadLine;
		this.jobTypes = jobTypes;
		this.fieldId = fieldId;
		this.applications = applications;
		this.types = types;
		this.field = field;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public Integer getFieldId() {
		return fieldId;
	}

	public void setFieldId(Integer fieldId) {
		this.fieldId = fieldId;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public Set<Type> getTypes() {
		return types;
	}

	public void setTypes(Set<Type> types) {
		this.types = types;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}
	
}
