package com.aa.awesomecareer.service;

import com.aa.awesomecareer.model.ExperienceModel;

public interface ExperienceService {
	
	public ExperienceModel save(ExperienceModel experienceModel);
	public ExperienceModel findById(Integer id);

}
