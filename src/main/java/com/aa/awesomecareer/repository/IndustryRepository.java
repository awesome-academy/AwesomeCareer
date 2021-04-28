package com.aa.awesomecareer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aa.awesomecareer.entity.Industry;


@Repository
public interface IndustryRepository extends JpaRepository<Industry, Integer> {

}
