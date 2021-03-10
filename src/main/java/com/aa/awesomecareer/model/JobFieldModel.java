package com.aa.awesomecareer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobFieldModel {
	private Integer id;
	private Integer jobId;
	private Integer fieldId;
	
	private JobModel jobModel;
	private FieldModel fieldModel;

}
