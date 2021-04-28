package com.aa.awesomecareer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.aa.awesomecareer.entity.Industry;
import com.aa.awesomecareer.model.IndustryModel;
import com.aa.awesomecareer.repository.IndustryRepository;
import com.aa.awesomecareer.service.IndustryService;

@Service
@Qualifier("industryService")
public class IndustryServiceImp implements IndustryService {
	private static final Logger logger = LoggerFactory.getLogger(IndustryServiceImp.class);
	
	@Autowired
	IndustryRepository industryRepository;
		
	@Override
	public List<IndustryModel> finAll() throws Exception {
		logger.info("load all industry in the database");
		try {
			List<Industry> industrys = industryRepository.findAll();
			List<IndustryModel> industryModelList = new ArrayList<IndustryModel>();
			for (Industry in : industrys) {
				IndustryModel industryModel = new IndustryModel();
				BeanUtils.copyProperties(in, industryModel);
				industryModelList.add(industryModel);
			}
			return industryModelList;
		}
		catch (Exception e) {
			logger.error("da xay ra loi khi load all industry tu database");
		}
		return null;
	}

}
