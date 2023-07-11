package com.exterro.feedbackquestion.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exterro.feedbackquestion.entity.QuestionEntity;
import com.exterro.feedbackquestion.entity.UserEntity;

@Repository
public interface QuestionDao extends JpaRepository<QuestionEntity, Integer> {
	Optional<QuestionEntity> findById(int questionId);
	
}
