package com.example.Recommender.DB.DAO;

import com.example.Recommender.DB.Mock.MockEntities;
import com.example.Recommender.DB.entities.User;
import com.example.Recommender.DB.repository.UserRepository;
import com.example.Recommender.constants.RecommendationProperties;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
public class UserDAO {

    private boolean isMockEnabled = RecommendationProperties.isIsMockServer();
    @Autowired(required = false)
    private UserRepository userRepository;

    public User getUserById(Long uid){
        if(isMockEnabled){
            return MockEntities.getMockUserValues(uid);
        }
        return userRepository.findById(uid).orElse(null);
    }

}
