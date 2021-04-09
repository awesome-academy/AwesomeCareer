package com.aa.awesomecareer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aa.awesomecareer.entity.Field;
import com.aa.awesomecareer.model.FieldModel;
import com.aa.awesomecareer.repository.FieldRepository;
import com.aa.awesomecareer.service.FieldService;

@Service
public class FieldServiceImp implements FieldService {

	@Autowired
	FieldRepository fieldRepository;
	
	@Override
	public List<FieldModel> findAll() {
		List<Field> fields = fieldRepository.findAll();
		List<FieldModel> fieldModels = new ArrayList<FieldModel>();
		for (Field field : fields) {
			FieldModel fieldModel = new FieldModel();
			BeanUtils.copyProperties(field, fieldModel);
			fieldModels.add(fieldModel);
		}
		return fieldModels;
	
	}

}
