package com.exterro.feedbackquestion.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exterro.feedbackquestion.entity.UserEntity;
@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer> {
	Optional<UserEntity> findById(int userId);
	
}
