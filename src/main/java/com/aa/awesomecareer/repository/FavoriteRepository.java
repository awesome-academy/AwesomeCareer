package com.aa.awesomecareer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aa.awesomecareer.entity.Favorite;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {

}
