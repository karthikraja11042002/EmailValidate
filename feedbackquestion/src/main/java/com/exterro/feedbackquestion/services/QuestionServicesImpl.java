package com.exterro.feedbackquestion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exterro.feedbackquestion.dao.QuestionDao;
import com.exterro.feedbackquestion.entity.QuestionEntity;
@Service
public class  QuestionServicesImpl implements QuestionServices {
         
	    @Autowired
	    QuestionDao questionDao ;
	
	@Override
	public QuestionEntity addQuestion(QuestionEntity question) {
		
		return questionDao.save(question);
	}

	@Override
	public List<QuestionEntity> viewAllQuestion() {
	
		return questionDao.findAll();
	}

}
