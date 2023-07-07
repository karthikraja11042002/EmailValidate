package com.exterro.feedbackquestion.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class QuestionEntity {
	@Id
	private int questionId;
	private String questionValue;
	private String optionA;

	public int getQuestionId() {
		return questionId;
	}

	public QuestionEntity() {

	}

	public QuestionEntity(int questionId, String questionValue, String optionA, String optionB, String optionC,
			String optionD) {

		this.questionId = questionId;
		this.questionValue = questionValue;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	@Override
	public String toString() {
		return "QuestionEntity [questionId=" + questionId + ", questionValue=" + questionValue + ", optionA=" + optionA
				+ ", optionB=" + optionB + ", optionC=" + optionC + ", optionD=" + optionD + "]";
	}

	public String getQuestionValue() {
		return questionValue;
	}

	public void setQuestionValue(String questionValue) {
		this.questionValue = questionValue;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	private String optionB;
	private String optionC;
	private String optionD;

}
