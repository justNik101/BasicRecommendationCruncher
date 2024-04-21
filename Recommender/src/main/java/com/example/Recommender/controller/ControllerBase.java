package com.example.Recommender.controller;

import com.example.Recommender.exception.RecommendationExceptionEnum;
import com.example.Recommender.exception.RecommendationFailureException;
import com.example.Recommender.pojo.SummaryResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Log4j2
public abstract class ControllerBase {
    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    SummaryResponse handleException(Exception e, HttpServletRequest httpServletRequest) {
        log.error(e,e);
        return SummaryResponse.buildFail("99",e.getMessage());
    }


    @ExceptionHandler(value = {RecommendationFailureException.class})
    @ResponseBody
    SummaryResponse handleRecommendValidationException(RecommendationFailureException e, HttpServletRequest httpServletRequest) {
        RecommendationExceptionEnum recommendationExceptionEnum = e.getExceptionEnum();
        return SummaryResponse.buildFail(recommendationExceptionEnum.getStatusCode(),
                recommendationExceptionEnum.getMessage());
    }


}
