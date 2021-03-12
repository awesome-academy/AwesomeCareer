package com.aa.awesomecareer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aa.awesomecareer.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}
