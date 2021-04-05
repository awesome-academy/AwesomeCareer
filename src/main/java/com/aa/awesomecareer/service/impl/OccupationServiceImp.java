package com.aa.awesomecareer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aa.awesomecareer.entity.Field;
import com.aa.awesomecareer.model.FieldModel;
import com.aa.awesomecareer.repository.OccupationRepository;
import com.aa.awesomecareer.service.FieldService;

@Service
public class OccupationServiceImp implements FieldService {

	@Autowired
	OccupationRepository occupationRepository;
	
	@Override
	public List<FieldModel> findAll() {
		List<Field> occupations = occupationRepository.findAll();
		List<FieldModel> occupationModels = new ArrayList<>();
		for (Field occupation : occupations) {
			FieldModel occupationModel = new FieldModel();
			BeanUtils.copyProperties(occupation, occupationModel);
			occupationModels.add(occupationModel);
		}
		return occupationModels;
	}

}
