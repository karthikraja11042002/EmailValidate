package com.exterro.feedbackquestion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exterro.feedbackquestion.dao.UserDao;
import com.exterro.feedbackquestion.entity.UserEntity;
@Service
public class UserServicesImpl implements UserServices {
	
	
	  @Autowired
	  private UserDao userDao ;

	@Override
	public UserEntity addUser(UserEntity user) {
		
		return userDao.save(user);
	}

	@Override
	public List<UserEntity> viewAllUser() {
		
		return userDao.findAll();
	}

	@Override
	public UserEntity viewUser(String userEmail) {
		
		return userDao.findById(userEmail).orElse(null);
	}

}
