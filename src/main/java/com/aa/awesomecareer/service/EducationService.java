package com.aa.awesomecareer.service;

import java.util.List;

import com.aa.awesomecareer.model.EducationModel;

public interface EducationService {

	void saveEducation(EducationModel educationModel);
	List<EducationModel> findAllByUserId(Integer userId);
	EducationModel findById(Integer id);
	void deleteEducationById(Integer id);
	
}
