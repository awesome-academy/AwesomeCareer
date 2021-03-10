package com.aa.awesomecareer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aa.awesomecareer.entity.Voting;

public interface VotingRepository extends JpaRepository<Voting, Integer> {

}
