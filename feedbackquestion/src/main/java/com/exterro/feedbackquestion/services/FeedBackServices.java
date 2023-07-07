package com.exterro.feedbackquestion.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exterro.feedbackquestion.entity.FeedBackEntity;
@Service
public interface FeedBackServices {

	public FeedBackEntity addFeedBack(FeedBackEntity feedBackEntity);

	public List<FeedBackEntity> viewAllFeedBackDetails();
	
	public FeedBackEntity viewFeedBack(String userEmail);

	public FeedBackEntity viewFeedBackById(int feedbackId);
}
