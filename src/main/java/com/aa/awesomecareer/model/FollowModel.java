package com.aa.awesomecareer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FollowModel {
	
	private Integer id;
	private Integer userId;
	private Integer companyId;
	
	private UserModel userModel;
	private CompanyModel companyModel;

}
