package com.example.Recommender.DB.DAO;

import com.example.Recommender.DB.Mock.MockEntities;
import com.example.Recommender.DB.entities.Skill;
import com.example.Recommender.DB.repository.SkillRepository;
import com.example.Recommender.constants.RecommendationProperties;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
public class SkillDAO {

    private boolean isMockEnabled = RecommendationProperties.isIsMockServer();
    @Autowired(required = false)
    private SkillRepository skillRepository;

    @Cacheable("skillCache")
    public Skill getSkill(Integer skill_id){
        log.info("Inside getSkill method with id {}",skill_id);
        if(isMockEnabled){
            return MockEntities.getSkillMockObjects(skill_id);
        }
        return skillRepository.findById(skill_id).orElse(null);
    }


}
