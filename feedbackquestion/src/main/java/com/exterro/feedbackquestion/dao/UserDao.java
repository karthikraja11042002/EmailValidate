package com.exterro.feedbackquestion.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exterro.feedbackquestion.entity.UserEntity;
@Repository
public interface UserDao extends JpaRepository<UserEntity, String> {

}
