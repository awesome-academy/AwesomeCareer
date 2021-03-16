package com.aa.awesomecareer.model;

import java.io.Serializable;

public class YearModel implements Serializable{
	
	private Integer id;
	private String name;
	
	public YearModel() {

	}
	
	public YearModel(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
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
	
	

}
