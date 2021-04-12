package com.aa.awesomecareer.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class ApplicationModel {

	private Integer id;
	private Integer userId;
	private Integer jobId;
	private MultipartFile file;
	private String fileUrl;
	
	private String jobName;
	private String applicantName;
	private Long qtyApplicant;
	
	private String status;
	
	
	public ApplicationModel() {
		super();
	}
	public ApplicationModel(Integer id, Integer userId, Integer jobId, MultipartFile file, String fileUrl) {
		super();
		this.id = id;
		this.userId = userId;
		this.jobId = jobId;
		this.file = file;
		this.fileUrl = fileUrl;
	}
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
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	public Long getQtyApplicant() {
		return qtyApplicant;
	}
	public void setQtyApplicant(Long qtyApplicant) {
		this.qtyApplicant = qtyApplicant;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}