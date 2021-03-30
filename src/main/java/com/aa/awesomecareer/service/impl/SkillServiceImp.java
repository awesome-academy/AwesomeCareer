package com.aa.awesomecareer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aa.awesomecareer.entity.Skill;
import com.aa.awesomecareer.model.SkillModel;
import com.aa.awesomecareer.repository.SkillRepository;
import com.aa.awesomecareer.service.SkillService;

@Service
public class SkillServiceImp implements SkillService{
	
	@Autowired
	SkillRepository skillRepository;

	@Override
	public List<SkillModel> findAll() {
		List<Skill> skills = skillRepository.findAll();
		List<SkillModel> skillModels = new ArrayList<SkillModel>();
		for(Skill skill : skills) {
			SkillModel skillModel = new SkillModel();
			BeanUtils.copyProperties(skill, skillModel);
			skillModels.add(skillModel);
		}
		return skillModels;
	}

}
