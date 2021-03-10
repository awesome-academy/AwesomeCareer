package com.aa.awesomecareer.model;

public class ProfileModel extends BaseModel {
	private Integer id;
	private String currentOccupation;
	private String location;
	private String tagLine;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCurrentOccupation() {
		return currentOccupation;
	}
	public void setCurrentOccupation(String currentOccupation) {
		this.currentOccupation = currentOccupation;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTagLine() {
		return tagLine;
	}
	public void setTagLine(String tagLine) {
		this.tagLine = tagLine;
	}
}
