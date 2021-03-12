package com.aa.awesomecareer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aa.awesomecareer.entity.Follow;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Integer> {

}
