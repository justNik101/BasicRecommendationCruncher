package com.example.Recommender;


import com.example.Recommender.constants.RecommendationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RecommenderApplication {

	@Autowired // for static variable value population
	private RecommendationProperties recommendationProperties;

	public static void main(String[] args) {
		SpringApplication.run(RecommenderApplication.class, args);
	}

}
