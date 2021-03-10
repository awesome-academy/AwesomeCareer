package com.aa.awesomecareer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceModel {
	private Integer id;
	private String companyName;
	private String jobTitle;
	private String startName;
	private String endTime;
	private String description;
	private UserModel userModel;

}
