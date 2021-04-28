package com.aa.awesomecareer.entity;

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

@SuppressWarnings("serial")
@Entity
@Table(name = "industry")
public class Industry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "industryName", length = 256)
	private String industryName;
	
	@OneToMany( mappedBy = "industry")
	private List<CompanyIndustry> industrys;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIndustryName() {
		return industryName;
	}
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}
	public List<CompanyIndustry> getIndustrys() {
		return industrys;
	}
	public void setIndustrys(List<CompanyIndustry> industrys) {
		this.industrys = industrys;
	}
	
	
}
