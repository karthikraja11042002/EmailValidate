package com.exterro.feedbackquestion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.exterro.feedbackquestion.dao.UserRepository;
import com.exterro.feedbackquestion.entity.User;



@SpringBootApplication
public class FeedbackquestionApplication {
	
	 private static final Logger logger = LoggerFactory.getLogger(FeedbackquestionApplication.class);

	public static void main(String[] args) {
		logger.info("In Main");
		SpringApplication.run(FeedbackquestionApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(UserRepository users, PasswordEncoder encoder) {
//		return args -> {
//			users.save(new User("admin",encoder.encode("admin123"),"ROLE_ADMIN"));
//		};
//	}
}
