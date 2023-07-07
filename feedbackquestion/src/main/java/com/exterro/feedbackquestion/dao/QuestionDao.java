package com.exterro.feedbackquestion.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exterro.feedbackquestion.entity.QuestionEntity;

@Repository
public interface QuestionDao extends JpaRepository<QuestionEntity, Integer> {

}
