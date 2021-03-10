package com.aa.awesomecareer.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyModel {
	private Integer id;
	private String name;
	private String address;
	private String website;
	private String foundedTime;
	private String foundedBy;
	private Integer memberTotal;
	private String image;
	List<JobModel> jobModels;
	List<FollowModel> followModels;
	List<MemberModel> memberModels;

}
