package com.example.Recommender.controller;

import com.example.Recommender.constants.RecommendationProperties;
import com.example.Recommender.pojo.RecommendationSummary;
import com.example.Recommender.pojo.SummaryResponse;
import com.example.Recommender.service.RecommendService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/recommendation")
public class MainController extends ControllerBase {
    @Autowired
    private RecommendService recommendService;

    @GetMapping("/summary/{uid}")
    public SummaryResponse getTotalRecommendationPerUser(@PathVariable Long uid){
        log.info("Received request for UID {} {}",uid, RecommendationProperties.isIsMockServer());
        List<RecommendationSummary> summaryList = recommendService.getRecommendationSummaryForUser(uid);
        log.info("going to return data {}",summaryList);
        return SummaryResponse.buildSuccess(summaryList);
    }

    @GetMapping("/")
    public String ping(){
        return "PONG";
    }
}
