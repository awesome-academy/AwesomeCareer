package com.aa.awesomecareer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TypeModel {
	
	private Integer id;
	private Integer jobId;
	private Integer jobTypeId;
	
	private JobModel jobModel;
	private JobTypeModel jobTypeModel;

}
