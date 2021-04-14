package com.aa.awesomecareer.model;

public class UserElasticModel {
	
	private Integer id;
	private String fullName;
	
	public UserElasticModel() {
		
	}

	public UserElasticModel(Integer id, String fullName) {
		super();
		this.id = id;
		this.fullName = fullName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
