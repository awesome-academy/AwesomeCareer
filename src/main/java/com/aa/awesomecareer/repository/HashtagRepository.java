package com.aa.awesomecareer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aa.awesomecareer.entity.Hashtag;

@Repository
public interface HashtagRepository extends JpaRepository<Hashtag, Integer> {

}
