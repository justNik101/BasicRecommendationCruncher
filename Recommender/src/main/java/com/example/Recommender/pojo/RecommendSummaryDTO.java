package com.example.Recommender.pojo;

import com.example.Recommender.DB.entities.Recommendation;
import com.example.Recommender.DB.entities.User;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class RecommendSummaryDTO {
    private User mainUser;
    private List<Recommendation> receivedRecommendationList;
}
