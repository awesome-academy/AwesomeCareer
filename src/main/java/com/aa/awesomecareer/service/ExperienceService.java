package com.aa.awesomecareer.service;

import java.util.List;

import com.aa.awesomecareer.model.ExperienceModel;

public interface ExperienceService {
	
	public ExperienceModel save(ExperienceModel experienceModel);
	public ExperienceModel findById(Integer id);
	public void deleteById(Integer id);
	public List<ExperienceModel> findAll();

}
