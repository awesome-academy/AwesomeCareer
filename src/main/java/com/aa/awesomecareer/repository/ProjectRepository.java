package com.aa.awesomecareer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aa.awesomecareer.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
