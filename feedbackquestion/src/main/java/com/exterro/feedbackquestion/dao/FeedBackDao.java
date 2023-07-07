package com.exterro.feedbackquestion.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exterro.feedbackquestion.entity.FeedBackEntity;
@Repository
public interface FeedBackDao extends JpaRepository<FeedBackEntity, Integer> {
	@Query(nativeQuery = true, value = "select * from feed_back_entity where user_email=?1")
    public FeedBackEntity findByUserEmail(String userEmail);
}
