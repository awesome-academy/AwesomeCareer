package com.aa.awesomecareer.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.aa.awesomecareer.entity.Field;
import com.aa.awesomecareer.entity.JobType;
import com.aa.awesomecareer.entity.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class JobModel extends BaseModel{
	
	private Integer id;
	private String jobTitle;
	private String companyWebsite;
	private String companyName;
	private String address;
	private String fieldName;
	private String position;
	private String introduction;
	private String description;
	private String requirement;
	private String reason;
	private Date deadLine;
	private List<JobType> jobTypes;
	private Integer fieldId;
    private Set<Type> types = new HashSet<>();
	private Field field;
	
	private Integer[] typeIds ;
	
	private List<TypeModel> typeModels = new ArrayList<>();

	public JobModel() {
		
	}

	public JobModel(Integer id, String jobTitle, String companyWebsite, String companyName, String address,
			String fieldName, String position, String introduction, String description, String requirement,
			String reason, Date deadLine, List<JobType> jobTypes, Integer fieldId, Set<Type> types, Field field,
			Integer[] typeIds, List<TypeModel> typeModels) {
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
		this.deadLine = deadLine;
		this.jobTypes = jobTypes;
		this.fieldId = fieldId;
		this.types = types;
		this.field = field;
		this.typeIds = typeIds;
		this.typeModels = typeModels;
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

	public Integer[] getTypeIds() {
		return typeIds;
	}

	public void setTypeIds(Integer[] typeIds) {
		this.typeIds = typeIds;
	}

	public List<TypeModel> getTypeModels() {
		return typeModels;
	}

	public void setTypeModels(List<TypeModel> typeModels) {
		this.typeModels = typeModels;
	}

}
