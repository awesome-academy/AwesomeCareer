package com.aa.awesomecareer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileInfoModel {
	
	private Integer id;
	private String currentOccupation;
	private String location;
	private String tagName;
	
	private UserModel userModel;

}
