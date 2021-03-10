package com.aa.awesomecareer.model;

import java.util.Date;

public class CompanyModel extends BaseModel {
	private Integer id;
	private String address;
	private String website;
	private Date foundedTime;
	private String foundedBy;
	private Integer memberTotal;
	private String name;
	private String image;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Date getFoundedTime() {
		return foundedTime;
	}
	public void setFoundedTime(Date foundedTime) {
		this.foundedTime = foundedTime;
	}
	public String getFoundedBy() {
		return foundedBy;
	}
	public void setFoundedBy(String foundedBy) {
		this.foundedBy = foundedBy;
	}
	public Integer getMemberTotal() {
		return memberTotal;
	}
	public void setMemberTotal(Integer memberTotal) {
		this.memberTotal = memberTotal;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
