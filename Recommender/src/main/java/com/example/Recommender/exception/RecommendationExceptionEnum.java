package com.example.Recommender.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RecommendationExceptionEnum {

    USER_DOES_NOT_EXIST("R_1","User does not exist"),
    NO_RECOMMENDATION_FOUND("R_2","No Recommendation Found"),
    FAULTY_RECOMMENDATION_FOUND("R_3","Faulty Recommendation Found"),
    ;

    private String statusCode;
    private String message;

}
