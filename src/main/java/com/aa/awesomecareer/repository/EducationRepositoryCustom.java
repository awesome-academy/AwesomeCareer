package com.aa.awesomecareer.repository;

import java.util.List;
import com.aa.awesomecareer.entity.Education;

public interface EducationRepositoryCustom {
     List<Education> findByUserId(Integer userId);
}
