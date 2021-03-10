package com.aa.awesomecareer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectModel {
	
	private Integer id;
	private String title;
	private String link;
	private String startDate;
	private String endDate;
	private String description;
	
	private UserModel useModelr;

}
