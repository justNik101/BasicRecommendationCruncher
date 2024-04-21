package com.example.Recommender.exception;

import lombok.Getter;
import org.springframework.core.NestedRuntimeException;

@Getter
public class RecommendationFailureException extends NestedRuntimeException {

    private RecommendationExceptionEnum exceptionEnum;

    public RecommendationFailureException(RecommendationExceptionEnum failureExceptionEnum){
        super(failureExceptionEnum.getMessage());
        this.exceptionEnum = failureExceptionEnum;
    }

    public RecommendationFailureException(RecommendationExceptionEnum failureExceptionEnum,
                                          Throwable throwable){
        super(failureExceptionEnum.getMessage(),throwable);
        this.exceptionEnum = failureExceptionEnum;
    }

}
