package com.aa.awesomecareer.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.aa.awesomecareer.entity.Experience;
import com.aa.awesomecareer.model.ExperienceModel;
import com.aa.awesomecareer.repository.ExperienceRepository;
import com.aa.awesomecareer.service.ExperienceService;

public class ExperienceServiceImp implements ExperienceService {
	
	@Autowired
	ExperienceRepository experienceRepo;
	
	public ExperienceModel save(ExperienceModel experienceModel) {
		
		Experience experience = new Experience();
		BeanUtils.copyProperties(experienceModel, experience);
		Experience newExperience = experienceRepo.save(experience);
		ExperienceModel newExperienceModel = new ExperienceModel();
		BeanUtils.copyProperties(newExperience, newExperienceModel);
		return newExperienceModel;
	}

	@Override
	public ExperienceModel findById(Integer id) {
		Optional<Experience> experienceOld = experienceRepo.findById(id);
		ExperienceModel experienceModel = new ExperienceModel();
		BeanUtils.copyProperties(experienceOld, experienceModel);
		return experienceModel;
	}

	@Override
	public void deleteById(Integer id) {
		experienceRepo.deleteById(id);
		
	}

	@Override
	public List<ExperienceModel> findAll() {
		List<Experience> experiences =experienceRepo.findAll();
		List<ExperienceModel> experienceModels = new ArrayList<ExperienceModel>();
		for(Experience ex : experiences) {
			ExperienceModel experienceModel = new ExperienceModel();
			BeanUtils.copyProperties(ex, experienceModel);
			experienceModels.add(experienceModel);
		}
		
		return experienceModels;
	}
	
	

}
