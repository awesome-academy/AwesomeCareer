package com.aa.awesomecareer.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aa.awesomecareer.entity.Education;
import com.aa.awesomecareer.model.EducationModel;
import com.aa.awesomecareer.repository.EducationRepository;
import com.aa.awesomecareer.service.EducationService;

@Service
public class EducationServiceImp implements EducationService {

	private static final Logger logger = LoggerFactory.getLogger(EducationServiceImp.class);

	@Autowired
	EducationRepository educationRepository;

	@Override
	public void saveEducation(EducationModel educationModel) {
		logger.info("education saving");
		try {
			Education education = new Education();
			BeanUtils.copyProperties(educationModel, education);
			educationRepository.save(education);
		} catch (Exception e) {
			logger.error("education save error", e);
		}
	}

	@Override
	public List<EducationModel> findAllByUserId(Integer userId) {
		logger.info("Finding all education object from database by UserID");
		try {
			List<Education> educations = educationRepository.findByUserId(userId);
			List<EducationModel> educationModels = new ArrayList<>();
			for (Education education : educations) {
				EducationModel educationModel = new EducationModel();
				BeanUtils.copyProperties(education, educationModel);
				educationModels.add(educationModel);
			}
			return educationModels;
		} catch (Exception e) {
			logger.error("An error occurred while fetching the education details from database", e);
			return null;
		}
	}

	@Override
	public EducationModel findById(Integer id) {
		logger.info("Finding education object from database by education id");
		try {
			Optional<Education> education = educationRepository.findById(id);
			EducationModel educationModel = new EducationModel();
			BeanUtils.copyProperties(education.get(), educationModel);

			return educationModel;
		} catch (Exception e) {
			logger.error("An error occurred while fetching the education details from database by education Id", e);
			return null;
		}
	}

	@Override
	public void deleteEducationById(Integer id) {
		logger.info("Delete education by id");
		educationRepository.deleteById(id);
	}
}