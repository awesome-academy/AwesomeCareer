package com.aa.awesomecareer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VotingModel {
	private Integer id;
	private Integer userId;
	private String jobId;
	private Integer score;
}
