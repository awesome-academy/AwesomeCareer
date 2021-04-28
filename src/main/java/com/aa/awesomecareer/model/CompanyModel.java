package com.aa.awesomecareer.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.aa.awesomecareer.entity.CompanyIndustry;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class CompanyModel {
	private Integer id;
	private String name;
	private String address;
	private String website;
	private Date foundedTime;
	private Integer foundedBy;
	private Integer totalMember;
	private String image;
	
	List<JobModel> jobModels;
	List<FollowModel> followModels;
	List<MemberModel> memberModels;
	private List<CompanyIndustry> companyModels;
	
	private List<Integer> industryIds = new ArrayList<Integer>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public Integer getFoundedBy() {
		return foundedBy;
	}
	public void setFoundedBy(Integer foundedBy) {
		this.foundedBy = foundedBy;
	}
	public Integer getTotalMember() {
		return totalMember;
	}
	public void setTotalMember(Integer totalMember) {
		this.totalMember = totalMember;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getFoundedTime() {
		return foundedTime;
	}
	public void setFoundedTime(Date foundedTime) {
		this.foundedTime = foundedTime;
	}
	public List<CompanyIndustry> getCompanyModels() {
		return companyModels;
	}
	public void setCompanyModels(List<CompanyIndustry> companyModels) {
		this.companyModels = companyModels;
	}
	public List<Integer> getIndustryIds() {
		return industryIds;
	}
	public void setIndustryIds(List<Integer> industryIds) {
		this.industryIds = industryIds;
	}
	
	
}
