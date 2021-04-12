package com.aa.awesomecareer.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
public class JobModel extends BaseModel {

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
	@JsonIgnore
	private MultipartFile image;
	private String imageUrl;
	private String shortDescription;
	private Integer userId;
	private UserModel userModel;
	private List<JobType> jobTypes;
	private Integer fieldId;
	private Long qtyJobByUserId;
	private Long qtyApplycantByJobId;
	private boolean existApplication;
	private String companyEmail;
    private Set<Type> types = new HashSet<>();
	private Field field;
	
	private Integer[] typeIds ;
	private List<TypeModel> typeModels = new ArrayList<>();
	
	public JobModel() {
		super();
	}

	public JobModel(Integer id, String jobTitle, String companyWebsite, String companyName, String address,
			String fieldName, String position, String introduction, String description, String requirement,
			String reason, Date deadLine, MultipartFile image, String imageUrl, String shortDescription, Integer userId,
			UserModel userModel, List<JobType> jobTypes, Integer fieldId, Set<Type> types, Field field,
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
		this.image = image;
		this.imageUrl = imageUrl;
		this.shortDescription = shortDescription;
		this.userId = userId;
		this.userModel = userModel;
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

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
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

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public List<JobTypeModel> getJobTypes() {
		return jobTypes;
	}

	public void setJobTypes(List<JobTypeModel> jobTypes) {
		this.jobTypes = jobTypes;
	}

	public Integer getFieldId() {
		return fieldId;
	}

	public void setFieldId(Integer fieldId) {
		this.fieldId = fieldId;
	}

	public Set<TypeModel> getTypes() {
		return types;
	}

	public void setTypes(Set<TypeModel> types) {
		this.types = types;
	}

	@JsonIgnore
	public FieldModel getField() {
		return field;
	}

	public void setField(FieldModel field) {
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


	public Long getQtyJobByUserId() {
		return qtyJobByUserId;

	@JsonIgnore
	public MultipartFile getImage() {
		return image;

	}

	public void setQtyJobByUserId(Long qtyJobByUserId) {
		this.qtyJobByUserId = qtyJobByUserId;
	}

	public Long getQtyApplycantByJobId() {
		return qtyApplycantByJobId;
	}

	public void setQtyApplycantByJobId(Long qtyApplycantByJobId) {
		this.qtyApplycantByJobId = qtyApplycantByJobId;
	}


	public boolean isExistApplication() {
		return existApplication;


	public void setExistApplication(boolean existApplication) {
		this.existApplication = existApplication;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

}
