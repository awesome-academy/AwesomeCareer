package com.aa.awesomecareer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aa.awesomecareer.entity.Experience;
import com.aa.awesomecareer.entity.SkillUser;

public interface SkillUserRepository extends JpaRepository<SkillUser, Integer>  {

}
