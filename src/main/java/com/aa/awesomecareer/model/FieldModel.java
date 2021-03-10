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
public class FieldModel {
	
	private Integer id;
	private String name;
	List<JobFieldModel> jobFieldModels;

}
