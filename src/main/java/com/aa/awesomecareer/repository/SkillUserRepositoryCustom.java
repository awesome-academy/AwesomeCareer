package com.aa.awesomecareer.repository;

import java.util.List;
import com.aa.awesomecareer.entity.SkillUser;

public interface SkillUserRepositoryCustom {
	List<SkillUser> findByUserId(Integer userId);
}
