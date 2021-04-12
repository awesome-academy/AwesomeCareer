package com.aa.awesomecareer.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aa.awesomecareer.entity.Experience;
import com.aa.awesomecareer.model.ExperienceModel;
import com.aa.awesomecareer.repository.ExperienceRepository;
import com.aa.awesomecareer.service.ExperienceService;

@Service
public class ExperienceServiceImp implements ExperienceService {
	private static final Logger logger = LoggerFactory.getLogger(ExperienceServiceImp.class);

	@Autowired
	ExperienceRepository experienceRepo;

	@Transactional
	public void save(ExperienceModel experienceModel) {
		logger.info("experience saving");
		try {
			Experience experience = new Experience();
			BeanUtils.copyProperties(experienceModel, experience);
			experienceRepo.save(experience);
		} catch (Exception e) {
			logger.error("experience save error", e);
		}

	}

	@Override
	public ExperienceModel findById(Integer id) {
		logger.info("Finding experience from database by id of experience");
		try {
		Optional<Experience> experience = experienceRepo.findById(id);
		ExperienceModel experienceModel = new ExperienceModel();
		BeanUtils.copyProperties(experience.get(), experienceModel);
		return experienceModel;
	}catch(Exception e) {
		logger.error("There is no experience in database find by id", e);
		return null;
	}
	}
	@Override
	public void delete(Integer id) {
		logger.info("delete experience from database by id of experience");
		experienceRepo.deleteById(id);
	}

	@Override
	public List<ExperienceModel> findAllById(Integer id) {
		logger.info("Finding all of experience from database");
		try {
			List<Experience> experiences = experienceRepo.findAllById(id);
			List<ExperienceModel> experienceModels = new ArrayList<ExperienceModel>();
			for (Experience ex : experiences) {
				System.out.println("Kiem tra xem co experience khoong " + ex.getCompanyName());
				ExperienceModel experienceModel = new ExperienceModel();
				BeanUtils.copyProperties(ex, experienceModel);
				experienceModels.add(experienceModel);
			}
			return experienceModels;
		} catch (Exception e) {
			logger.error("There is no experience in database", e);
			return null;
		}
	}
}
