package com.example.Recommender.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SummaryResponse {
    private boolean isSuccess;
    private List<RecommendationSummary> summaryList;
    private ErrorApiResponse errorMsg;

    private SummaryResponse(boolean success, List<RecommendationSummary> summaryList){
        this.isSuccess = success;
        this.summaryList = summaryList;
    }

    private SummaryResponse(boolean success, ErrorApiResponse message){
        this.isSuccess = success;
        this.errorMsg = message;
    }

    public static SummaryResponse buildFail(String code, String text) {
        return new SummaryResponse(Boolean.FALSE,
                ErrorApiResponse.build(code,text));
    }

    public static SummaryResponse buildSuccess(List<RecommendationSummary> data) {
        return new SummaryResponse(Boolean.TRUE, data);
    }

}
