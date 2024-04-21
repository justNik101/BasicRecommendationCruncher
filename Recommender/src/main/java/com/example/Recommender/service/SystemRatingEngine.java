package com.example.Recommender.service;

import com.example.Recommender.DB.entities.Recommendation;
import com.example.Recommender.DB.entities.User;
import com.example.Recommender.DB.DAO.UserDAO;
import com.example.Recommender.exception.RecommendationExceptionEnum;
import com.example.Recommender.exception.RecommendationFailureException;
import com.example.Recommender.pojo.RecommendationSummary;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Log4j2
@Component
public class SystemRatingEngine {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private SkillMatcher skillMatcher;

    /**
     * calculating System score
     * (0.25 * skill_match_factor + 0.15 * experience_factor + 0.2 * coworker_factor) * rated_score
     * here skill_match_factor can have
     *    2 - if skill group match,
     *    1 - if skill group are somehow related
     *    0 - if skill group are not related
     * here experience_factor can be
     *    2 - if recommender has more experience than recommendee (senior than 3 years)
     *    1 - if recommender equal experience than recommendee (same experience to experience + 3 year)
     *    0 -> if recommender is junior
     * here coworker_factor is 1 if both users are co workers
     */
    public RecommendationSummary calculateSystemScoreAndBuildSummary(Recommendation recommendation, User mainUser){
        User recommender = userDAO.getUserById(recommendation.getSenderUid());
        if(recommender == null){
            log.info("No user found for {} which is not expected thus failing it",
                    recommendation.getSenderUid());
            throw new RecommendationFailureException(RecommendationExceptionEnum.FAULTY_RECOMMENDATION_FOUND);
        }
        Boolean areCoworkers = Boolean.FALSE;
        if(mainUser.getCompanyName().equals(recommender.getCompanyName())){
            areCoworkers = Boolean.TRUE;
        }
        Integer skillRelevance = calculateSkillRelevance(mainUser, recommender);

        Integer experienceRelevance = calculateExperienceRelevance(mainUser, recommender);

        BigDecimal skillScore = BigDecimal.valueOf(0.25).multiply( BigDecimal.valueOf(skillRelevance) );
        BigDecimal experienceScore = BigDecimal.valueOf(0.15).multiply( BigDecimal.valueOf(experienceRelevance) );
        BigDecimal coWorkerScore = BigDecimal.valueOf(0.2).multiply(
                areCoworkers?BigDecimal.ONE:BigDecimal.ZERO);

        BigDecimal systemScore = skillScore.add(experienceScore)
                .add(coWorkerScore).multiply(new BigDecimal(recommender.getTotalYearsOfExperience()));
        log.info("UserId {} Recommender {} systemScore {} expScore {} coWork {} skillScore {} yrExp {}",
                mainUser.getId(), recommender.getId(), systemScore, experienceScore, coWorkerScore,
                skillScore, recommender.getTotalYearsOfExperience());
        return RecommendationSummary.builder()
                .recommender(recommendation.getSenderUid())
                .ratedScore(recommendation.getScore())
                .systemScore(systemScore)
                .build();
    }

    private Integer calculateExperienceRelevance(User mainUser, User recommender) {
        Integer experienceRelevance = 0;
        Integer experienceDifference = recommender.getTotalYearsOfExperience() - mainUser.getTotalYearsOfExperience();

        if(experienceDifference > 3){
            experienceRelevance = 2;
        }
        else if(experienceDifference >= 0 && experienceDifference <= 3){
            experienceRelevance = 1;
        }
        else{
            experienceRelevance = 0;
        }
        return experienceRelevance;
    }

    private Integer calculateSkillRelevance(User mainUser, User recommender){
        Integer experienceRelevance = 0;
        Integer levelMatch = skillMatcher.matchLevel(mainUser.getSkillId(), recommender.getSkillId());
        if(levelMatch.equals(0)){
            experienceRelevance = 2;
        }
        else if(levelMatch.equals(1)){
            experienceRelevance = 1;
        }
        else {
            // levelMatch > 1 then no relevant
            experienceRelevance = 0;
        }
        return experienceRelevance;
    }

}
