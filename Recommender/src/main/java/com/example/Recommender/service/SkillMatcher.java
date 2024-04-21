package com.example.Recommender.service;

import com.example.Recommender.DB.entities.Skill;
import com.example.Recommender.DB.DAO.SkillDAO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

@Component
public class SkillMatcher {
    @Autowired
    private SkillDAO skillDAO;

    // skill cache map -> no need for the same since anyway i am caching within skillDAO methods
    //private Map<Integer,Integer> skillParentCache = new HashMap<>();

    @Cacheable("matchLevelCache")
    public Integer matchLevel(Integer skillIdOne, Integer skillIdTwo){
        return  commonMatchHierarchyLevel(skillIdOne, skillIdTwo);
    }

    /**
     * here skillIdOne and skillIdTwo are supposed to be leaf skill
     * this function is performing inverted tree traversal for finding common level
     * @param skillIdOne
     * @param skillIdTwo
     * @return level of commonality (wrt hierarchy)
     */
    private Integer commonMatchHierarchyLevel(Integer skillIdOne, Integer skillIdTwo){
        Integer level = 0;
        Queue<SkillComparer> queue = new LinkedList<>();
        queue.offer(new SkillComparer(skillIdOne, skillIdTwo));
        while(!queue.isEmpty()){
            SkillComparer skillComparer = queue.remove();
            if(skillComparer.skillIdOne.equals(skillComparer.skillIdTwo)){
                return level;
            }
            else{
                Skill skillOne, skillTwo;

                skillOne = skillDAO.getSkill(skillComparer.skillIdOne);

                skillComparer.skillIdOne = skillOne.getParentSkillGroupId();

                skillTwo = skillDAO.getSkill(skillComparer.skillIdTwo);

                skillComparer.skillIdTwo = skillTwo.getParentSkillGroupId();
                level++;
                queue.offer(skillComparer);
            }
        }
        return level;
    }

    @AllArgsConstructor
    static class SkillComparer {
        Integer skillIdOne;
        Integer skillIdTwo;
    }

}
