package com.exterro.feedbackquestion.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exterro.feedbackquestion.entity.UserEntity;
@Service
public interface UserServices {

	public UserEntity addUser(UserEntity user);

	public List<UserEntity> viewAllUser();
	
	public UserEntity viewUser (String userEmail);

}
