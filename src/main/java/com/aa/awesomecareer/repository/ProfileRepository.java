package com.aa.awesomecareer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aa.awesomecareer.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {

}
