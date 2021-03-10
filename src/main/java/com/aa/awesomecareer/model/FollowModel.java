package com.aa.awesomecareer.model;

public class FollowModel extends BaseModel {
	private Integer followID;
	private Integer userId;
	private Integer companyId;
	
	public Integer getFollowID() {
		return followID;
	}
	public void setFollowID(Integer followID) {
		this.followID = followID;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
}
