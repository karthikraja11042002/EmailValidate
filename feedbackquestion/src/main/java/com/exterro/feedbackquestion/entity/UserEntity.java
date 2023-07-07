package com.exterro.feedbackquestion.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserEntity {
	private String userName;
	private String userAge;
	@Id
	private String userEmail;
	
	public String getUserName() {
		return userName;
	}
	public UserEntity(String userName, String userAge, String userEmail) {
	
		this.userName = userName;
		this.userAge = userAge;
		this.userEmail = userEmail;
	}
	public UserEntity() {
		
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "UserEntity [userName=" + userName + ", userAge=" + userAge + ", userEmail=" + userEmail + "]";
	}
	public String getUserAge() {
		return userAge;
	}
	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}
