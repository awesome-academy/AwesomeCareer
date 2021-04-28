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

@SuppressWarnings("serial")
@Entity
@Table(name = "company")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name", length = 256)
	private String name;
	@Column(name = "address", length = 256)
	private String address;
	@Column(name = "website", length = 128)
	private String website;
	@Column(name = "foundedTime")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date foundedTime;
	@Column(name = "foundedBy")
	private Integer foundedBy;
	@Column(name = "totalMember")
	private Integer totalMember;
	@Column(name = "image", length = 256)
	private String image;
	
	@OneToMany( mappedBy = "company")
	private List<CompanyIndustry> companys;
	
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
	public Date getFoundedTime() {
		return foundedTime;
	}
	public void setFoundedTime(Date foundedTime) {
		this.foundedTime = foundedTime;
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
	public List<CompanyIndustry> getCompanys() {
		return companys;
	}
	public void setCompanys(List<CompanyIndustry> companys) {
		this.companys = companys;
	}
	
	
}
