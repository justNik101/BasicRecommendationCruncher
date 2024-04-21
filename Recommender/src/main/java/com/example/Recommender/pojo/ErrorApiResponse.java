package com.example.Recommender.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.ToString;

@JsonInclude(Include.NON_NULL)
@Getter
@ToString
public class ErrorApiResponse {

    private String code;
    private String text;

    private ErrorApiResponse(String code, String text) {
        this.code = code;
        this.text = text;
    }

    public static ErrorApiResponse build(String code, String text) {
        ErrorApiResponse errorApiResponse = new ErrorApiResponse(code, text);
        return errorApiResponse;
    }

}
