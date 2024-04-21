package com.example.Recommender.DB.Mock;

import com.example.Recommender.DB.entities.Recommendation;
import com.example.Recommender.DB.entities.Skill;
import com.example.Recommender.DB.entities.User;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Log4j2
public class MockEntities {

    public static Skill getSkillMockObjects(Integer skill_id){
        if(skill_id.equals(1)){
            return Skill.builder()
                    .id(skill_id)
                    .skillGroup("RootSkill")
                    .parentSkillGroupId(1)
                    .build();
        }
        else if(skill_id.equals(2)){
            return Skill.builder()
                    .id(skill_id)
                    .skillGroup("Tech")
                    .parentSkillGroupId(1)
                    .build();
        }
        else if(skill_id.equals(3)){
            return Skill.builder()
                    .id(skill_id)
                    .skillGroup("NonTech")
                    .parentSkillGroupId(1)
                    .build();
        }
        else if(skill_id.equals(4)){
            return Skill.builder()
                    .id(skill_id)
                    .skillGroup("Java")
                    .parentSkillGroupId(2)
                    .build();
        }
        else if(skill_id.equals(5)){
            return Skill.builder()
                    .id(skill_id)
                    .skillGroup("Python")
                    .parentSkillGroupId(2)
                    .build();
        }
        else if(skill_id.equals(6)){
            return Skill.builder()
                    .id(skill_id)
                    .skillGroup("Business Development")
                    .parentSkillGroupId(3)
                    .build();
        }
        else if(skill_id.equals(7)){
            return Skill.builder()
                    .id(skill_id)
                    .skillGroup("Marketing")
                    .parentSkillGroupId(3)
                    .build();
        }

        return null;
    }

    public static User getMockUserValues(Long uid){
        log.info("Inside mock user values method for uid {}", uid);
        if(uid.equals(1L)) {
            return User.builder()
                    .id(uid)
                    .companyName("XYZ")
                    .emailId("something1@gmail.com")
                    .totalYearsOfExperience(4)
                    .skillId(4)
                    .build();
        }
        else if(uid.equals(2L)) {
            return User.builder()
                    .id(uid)
                    .companyName("XYZ")
                    .emailId("something2@gmail.com")
                    .totalYearsOfExperience(4)
                    .skillId(4)
                    .build();
        }
        else if(uid.equals(3L)){
            return User.builder()
                    .id(uid)
                    .companyName("XYZ")
                    .emailId("something3@gmail.com")
                    .totalYearsOfExperience(4)
                    .skillId(5)
                    .build();
        }
        else if(uid.equals(4L)){
            return User.builder()
                    .id(uid)
                    .companyName("XYZ")
                    .emailId("something4@gmail.com")
                    .totalYearsOfExperience(4)
                    .skillId(6)
                    .build();
        }
        else if(uid.equals(5L)){
            return User.builder()
                    .id(uid)
                    .companyName("XYZ")
                    .emailId("something5@gmail.com")
                    .totalYearsOfExperience(4)
                    .skillId(7)
                    .build();
        }
        else{
            return null;
        }
    }

    public static List<Recommendation> fetchAllRecommendationsReceived(Long userId){
        if(userId.equals(1L)){
            List<Recommendation> recommendationList = new ArrayList<>();
            recommendationList.add(Recommendation.builder()
                    .id(1)
                    .receiverUid( Long.valueOf(userId) )
                    .senderUid( Long.valueOf("2") )
                    .score(4)
                    .build());
            recommendationList.add(Recommendation.builder()
                    .id(2)
                    .receiverUid( Long.valueOf(userId) )
                    .senderUid( Long.valueOf("3") )
                    .score(4)
                    .build());
            recommendationList.add(Recommendation.builder()
                    .id(3)
                    .receiverUid( Long.valueOf(userId) )
                    .senderUid( Long.valueOf("4") )
                    .score(4)
                    .build());
            recommendationList.add(Recommendation.builder()
                    .id(4)
                    .receiverUid( Long.valueOf(userId) )
                    .senderUid( Long.valueOf("5") )
                    .score(4)
                    .build());
            return recommendationList;
        }
        else if(userId.equals(2L)){
            List<Recommendation> recommendationList = new ArrayList<>();
            recommendationList.add(Recommendation.builder()
                    .id(5)
                    .receiverUid( Long.valueOf(userId) )
                    .senderUid( Long.valueOf("1") )
                    .score(4)
                    .build());
            recommendationList.add(Recommendation.builder()
                    .id(6)
                    .receiverUid( Long.valueOf(userId) )
                    .senderUid( Long.valueOf("3") )
                    .score(4)
                    .build());
            recommendationList.add(Recommendation.builder()
                    .id(7)
                    .receiverUid( Long.valueOf(userId) )
                    .senderUid( Long.valueOf("4") )
                    .score(4)
                    .build());
            recommendationList.add(Recommendation.builder()
                    .id(8)
                    .receiverUid( Long.valueOf(userId) )
                    .senderUid( Long.valueOf("5") )
                    .score(4)
                    .build());
            return recommendationList;
        }
        else if(userId.equals(3L)){
            List<Recommendation> recommendationList = new ArrayList<>();
            recommendationList.add(Recommendation.builder()
                    .id(9)
                    .receiverUid( Long.valueOf(userId) )
                    .senderUid( Long.valueOf("2") )
                    .score(4)
                    .build());
            recommendationList.add(Recommendation.builder()
                    .id(10)
                    .receiverUid( Long.valueOf(userId) )
                    .senderUid( Long.valueOf("1") )
                    .score(4)
                    .build());
            recommendationList.add(Recommendation.builder()
                    .id(11)
                    .receiverUid( Long.valueOf(userId) )
                    .senderUid( Long.valueOf("4") )
                    .score(4)
                    .build());
            recommendationList.add(Recommendation.builder()
                    .id(12)
                    .receiverUid( Long.valueOf(userId) )
                    .senderUid( Long.valueOf("5") )
                    .score(4)
                    .build());
            return recommendationList;
        }
        else if(userId.equals(4L)){
            List<Recommendation> recommendationList = new ArrayList<>();
            recommendationList.add(Recommendation.builder()
                    .id(13)
                    .receiverUid( Long.valueOf(userId) )
                    .senderUid( Long.valueOf("2") )
                    .score(4)
                    .build());
            recommendationList.add(Recommendation.builder()
                    .id(14)
                    .receiverUid( Long.valueOf(userId) )
                    .senderUid( Long.valueOf("1") )
                    .score(4)
                    .build());
            recommendationList.add(Recommendation.builder()
                    .id(15)
                    .receiverUid( Long.valueOf(userId) )
                    .senderUid( Long.valueOf("3") )
                    .score(4)
                    .build());
            recommendationList.add(Recommendation.builder()
                    .id(16)
                    .receiverUid( Long.valueOf(userId) )
                    .senderUid( Long.valueOf("5") )
                    .score(4)
                    .build());
            return recommendationList;
        }
        return Collections.emptyList();
    }
}
