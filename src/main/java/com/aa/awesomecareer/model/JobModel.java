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
public class JobModel {
	
	private Integer id;
	private Integer companyId;
	private String jobTitle;
	private String discription;
	private String endTime;
	private String author;
	
	private CompanyModel companyModel;
	private List<ApplicationModel> applicationModels;
	private List<BookmarkModel> bookmarkModels;
	private List<VotingModel> votingModels;
	private List<TypeModel> typeModels;
	private List<JobTypeModel> jobTypeModels;
	

}
