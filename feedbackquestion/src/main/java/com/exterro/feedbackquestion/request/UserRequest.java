package com.exterro.feedbackquestion.request;

public class UserRequest {
	private String userName;
	private int userAge;
	private String userEmail;
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	private String answer5;

	public UserRequest() {

	}

	public UserRequest(String userName, int userAge, String userEmail, String answer1, String answer2, String answer3,
			String answer4, String answer5) {
		super();
		this.userName = userName;
		this.userAge = userAge;
		this.userEmail = userEmail;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		this.answer5 = answer5;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public String getAnswer4() {
		return answer4;
	}

	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}

	public String getAnswer5() {
		return answer5;
	}

	public void setAnswer5(String answer5) {
		this.answer5 = answer5;
	}

	@Override
	public String toString() {
		return "UserRequest [userName=" + userName + ", userAge=" + userAge + ", userEmail=" + userEmail + ", answer1="
				+ answer1 + ", answer2=" + answer2 + ", answer3=" + answer3 + ", answer4=" + answer4 + ", answer5="
				+ answer5 + "]";
	}

}
