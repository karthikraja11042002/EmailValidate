package com.exterro.feedbackquestion.services;
import java.util.List;
import org.springframework.stereotype.Service;
import com.exterro.feedbackquestion.entity.QuestionEntity;

@Service
public interface QuestionServices {

	public QuestionEntity addQuestion(QuestionEntity question);

	public List<QuestionEntity> viewAllQuestion();

}
