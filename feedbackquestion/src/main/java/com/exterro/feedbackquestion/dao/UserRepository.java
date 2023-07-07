package com.exterro.feedbackquestion.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.exterro.feedbackquestion.entity.User;

public interface UserRepository extends CrudRepository<User,Long> {

    Optional<User> findByUsername(String username);

}
