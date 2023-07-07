package com.exterro.feedbackquestion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exterro.feedbackquestion.dao.FeedBackDao;
import com.exterro.feedbackquestion.entity.FeedBackEntity;
@Service
public class FeedBackServicesImpl implements FeedBackServices {
	
		       @Autowired 
	       FeedBackDao feedBackDao ;

	@Override
	public FeedBackEntity addFeedBack(FeedBackEntity feedBackEntity) {
		
		return feedBackDao.save(feedBackEntity);
	}

	@Override
	public List<FeedBackEntity> viewAllFeedBackDetails() {
		
		return feedBackDao.findAll();
		
	}

	@Override
	public FeedBackEntity viewFeedBack(String userEmail) {
		
		return feedBackDao.findByUserEmail(userEmail);
	}

	@Override
	public FeedBackEntity viewFeedBackById(int feedbackId) {
		return feedBackDao.findById(feedbackId).orElse(null);
	}

	
}
