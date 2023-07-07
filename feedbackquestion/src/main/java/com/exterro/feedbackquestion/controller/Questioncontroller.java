package com.exterro.feedbackquestion.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.exterro.feedbackquestion.entity.QuestionEntity;
import com.exterro.feedbackquestion.services.QuestionServices;
@Controller
public class Questioncontroller {

	private static final Logger logger = LoggerFactory.getLogger(Questioncontroller.class);
	@Autowired
	private QuestionServices questionService;

	@GetMapping("giveFeedback")
	@ResponseBody
	public ResponseEntity<List<QuestionEntity>> viewQuestion() {
		logger.info("accessing viewQuestion Method");

		List<QuestionEntity> result = questionService.viewAllQuestion();
		return ResponseEntity.ok(result);

	}
}
