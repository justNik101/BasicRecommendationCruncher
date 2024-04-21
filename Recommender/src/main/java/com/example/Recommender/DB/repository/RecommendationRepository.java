package com.example.Recommender.DB.repository;

import com.example.Recommender.DB.entities.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation,Integer> {

    List<Recommendation> findAllByReceiverUid(Long receiverUid);
}
