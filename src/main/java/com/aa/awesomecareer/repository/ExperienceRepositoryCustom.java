package com.aa.awesomecareer.repository;

import java.util.List;

import com.aa.awesomecareer.entity.Experience;

public interface ExperienceRepositoryCustom {
	List<Experience> findAllById(Integer userId);
}
