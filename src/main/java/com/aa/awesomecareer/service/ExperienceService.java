package com.aa.awesomecareer.service;

import java.text.ParseException;
import java.util.List;

import com.aa.awesomecareer.model.ExperienceModel;

public interface ExperienceService {
	
	public void save(ExperienceModel experienceModel) throws ParseException;
	public ExperienceModel findById(Integer id);
	public void delete(Integer id);
	List<ExperienceModel> findAllById(Integer id);

}
