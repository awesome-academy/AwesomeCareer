package com.aa.awesomecareer.model;

public class StoryHashtagModel extends BaseModel {
	private Integer id;
	private Integer storyId;
	private Integer hashTagId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStoryId() {
		return storyId;
	}
	public void setStoryId(Integer storyId) {
		this.storyId = storyId;
	}
	public Integer getHashTagId() {
		return hashTagId;
	}
	public void setHashTagId(Integer hashTagId) {
		this.hashTagId = hashTagId;
	}
}
