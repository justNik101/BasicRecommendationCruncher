package com.example.Recommender.service;

import com.example.Recommender.DB.entities.Recommendation;
import com.example.Recommender.DB.entities.User;
import com.example.Recommender.DB.DAO.RecommendationDAO;
import com.example.Recommender.DB.DAO.UserDAO;
import com.example.Recommender.exception.RecommendationFailureException;
import com.example.Recommender.exception.RecommendationExceptionEnum;
import com.example.Recommender.pojo.RecommendSummaryDTO;
import com.example.Recommender.pojo.RecommendationSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecommendService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private RecommendationDAO recommendationDAO;

    @Autowired
    private SystemRatingEngine systemRatingEngine;

    public List<RecommendationSummary> getRecommendationSummaryForUser(Long uid){
        User user = userDAO.getUserById(uid);
        if(user == null){
            throw new RecommendationFailureException(RecommendationExceptionEnum.USER_DOES_NOT_EXIST);
        }
        List<Recommendation> recommendationList = recommendationDAO.fetchAllRecommendationsReceived(uid);
        if (CollectionUtils.isEmpty(recommendationList)){
            throw new RecommendationFailureException(RecommendationExceptionEnum.NO_RECOMMENDATION_FOUND);
        }
        RecommendSummaryDTO recommendSummaryDTO = RecommendSummaryDTO.builder()
                .mainUser(user)
                .receivedRecommendationList(recommendationList)
                .build();

        List<RecommendationSummary> summaryList = compileFinalRecommendation(recommendSummaryDTO);
        return summaryList;
    }

    private List<RecommendationSummary> compileFinalRecommendation(RecommendSummaryDTO recommendSummaryDTO){
        List<RecommendationSummary> recommendationSummaries = new ArrayList<>();
        for(Recommendation recommendation: recommendSummaryDTO.getReceivedRecommendationList()){
            recommendationSummaries.add(
                    systemRatingEngine
                            .calculateSystemScoreAndBuildSummary(recommendation,
                                    recommendSummaryDTO.getMainUser())
            );
        }
        return recommendationSummaries;
    }
}
