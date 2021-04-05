package com.aa.awesomecareer.model;

import java.util.List;

public class FieldModel {
	
	private Integer id;
	private String name;

	public FieldModel() {
		
	}
	
	public FieldModel(Integer id, String name) {
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
