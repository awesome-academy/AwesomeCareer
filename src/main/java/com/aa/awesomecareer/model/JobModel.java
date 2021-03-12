package com.aa.awesomecareer.model;

import java.util.Date;
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
	private String description;
	private Date endTime;
	private String author;
}
