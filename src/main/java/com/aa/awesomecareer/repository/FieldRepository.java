package com.aa.awesomecareer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aa.awesomecareer.entity.Field;

@Repository
public interface FieldRepository extends JpaRepository<Field, Integer> {

}
