package com.example.Recommender.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RecommendationProperties {

    public static final String MOCK_OBJECT_PROPERTY_KEY = "run.on.mock.objects";

    private static boolean isMockServer;

    @Value("${" +  MOCK_OBJECT_PROPERTY_KEY + "}")
    public void setIsMockServer(boolean isMock){
        isMockServer = isMock;
    }

    public static boolean isIsMockServer(){
        return isMockServer;
    }

    public static final String RECOMMENDATION_DB_BASE_PATH = "com.example.Recommender.DB";
    public static final String RECOMMENDATION_ENTITY_PATH = "com.example.Recommender.DB.entities";


}
