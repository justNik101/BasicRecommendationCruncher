package com.example.Recommender.pojo;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class RecommendationSummary {
    Long recommender;
    Integer ratedScore;
    BigDecimal systemScore;
}
