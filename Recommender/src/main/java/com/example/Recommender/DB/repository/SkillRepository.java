package com.example.Recommender.DB.repository;


import com.example.Recommender.DB.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill,Integer> {

}
