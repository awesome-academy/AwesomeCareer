package com.aa.awesomecareer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aa.awesomecareer.entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer>,ApplicationRepositoryCustom {

}
