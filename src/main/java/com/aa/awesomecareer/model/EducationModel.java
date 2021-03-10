package com.aa.awesomecareer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EducationModel {
	
	private Integer id;
	private Integer userId;
	private String school;
	private String major;
	private String description;
	private String graduation;
	private UserModel userModel;

}
