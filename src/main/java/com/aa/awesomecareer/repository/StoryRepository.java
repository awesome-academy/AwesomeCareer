package com.aa.awesomecareer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aa.awesomecareer.entity.Story;

public interface StoryRepository extends JpaRepository<Story, Integer> {

}
