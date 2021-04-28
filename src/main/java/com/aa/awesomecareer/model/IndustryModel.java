package com.aa.awesomecareer.model;

import java.util.List;

import com.aa.awesomecareer.entity.CompanyIndustry;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class IndustryModel {
	private Integer id;
	private String industryName;
	
	private List<CompanyIndustry> industryModels;
	
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
	public List<CompanyIndustry> getIndustryModels() {
		return industryModels;
	}
	public void setIndustryModels(List<CompanyIndustry> industryModels) {
		this.industryModels = industryModels;
	}
	
}
