package com.example.Recommender.DB.DAO;

import com.example.Recommender.DB.Mock.MockEntities;
import com.example.Recommender.DB.entities.Recommendation;
import com.example.Recommender.DB.repository.RecommendationRepository;
import com.example.Recommender.constants.RecommendationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class RecommendationDAO {

    private boolean isMockEnabled = RecommendationProperties.isIsMockServer();
    @Autowired(required = false)
    private RecommendationRepository recommendationRepository;

    public List<Recommendation> fetchAllRecommendationsReceived(Long userId){
        if(isMockEnabled){
            return MockEntities.fetchAllRecommendationsReceived(userId);
        }
        return recommendationRepository.findAllByReceiverUid(userId);
    }

}
