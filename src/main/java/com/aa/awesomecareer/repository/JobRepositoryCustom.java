package com.aa.awesomecareer.repository;

import java.util.List;

import com.aa.awesomecareer.entity.Job;

public interface JobRepositoryCustom {
          List<Job> findByUserId(Integer id);
}
