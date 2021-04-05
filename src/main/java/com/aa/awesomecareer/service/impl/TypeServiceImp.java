package com.aa.awesomecareer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aa.awesomecareer.entity.Type;
import com.aa.awesomecareer.model.TypeModel;
import com.aa.awesomecareer.repository.TypeRepository;
import com.aa.awesomecareer.service.TypeService;

@Service
public class TypeServiceImp implements TypeService {

	@Autowired
	TypeRepository typeRepository;
	
	@Override
	public List<TypeModel> findAll() {
		List<Type> types = typeRepository.findAll();
		List<TypeModel> typeModels = new ArrayList<>();
		for(Type type : types) {
		TypeModel typeModel = new TypeModel();
		BeanUtils.copyProperties(type, typeModel);
		typeModels.add(typeModel);
		}
		return typeModels;
	}

}
