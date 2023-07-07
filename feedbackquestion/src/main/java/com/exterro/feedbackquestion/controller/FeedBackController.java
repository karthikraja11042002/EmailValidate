package com.exterro.feedbackquestion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exterro.feedbackquestion.entity.FeedBackEntity;
import com.exterro.feedbackquestion.entity.UserEntity;
import com.exterro.feedbackquestion.services.FeedBackServices;
import com.exterro.feedbackquestion.services.QuestionServices;
import com.exterro.feedbackquestion.services.UserServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class FeedBackController {

	private static final Logger logger = LoggerFactory.getLogger(FeedBackController.class);

	@Autowired
	private FeedBackServices feedBackServices;

	@Autowired
	private QuestionServices questionService;

	@Autowired
	private UserServices userServices;

	@GetMapping("/home")
	@ResponseBody
	public String getData() {
		String str = "<a href='admin.html'>ADMIN</a><br><br><a href='feedback.html'>USER</a>";
		return str;
	}

	@GetMapping("/feed")
	@ResponseBody
	public String getFeed() {
		return "feedback.html";
	}

	@PostMapping(path = "/submitRegistration")
	@ResponseBody
	public ResponseEntity<String> submitRegistration(@RequestParam String userData, HttpServletResponse response)
			throws JsonMappingException, JsonProcessingException {
		logger.info("Accessing submitRegistration method");
		ObjectMapper objmap = new ObjectMapper();
		UserEntity user = objmap.readValue(userData, UserEntity.class);
		userServices.addUser(user);

		Cookie nameCookie = new Cookie("userName", user.getUserName());
		nameCookie.setMaxAge(3600);
		response.addCookie(nameCookie);

		Cookie ageCookie = new Cookie("userAge", user.getUserAge());
		ageCookie.setMaxAge(3600);
		response.addCookie(ageCookie);

		Cookie emailCookie = new Cookie("userEmail", user.getUserEmail());
		emailCookie.setMaxAge(3600);
		response.addCookie(emailCookie);

		return ResponseEntity.ok("questions.html");
	}

	@PostMapping(path = "/submitFeedback")
	@ResponseBody
	public ResponseEntity<String> submitFeedback(@RequestParam String userAnswers, HttpServletRequest request,
			HttpServletResponse response) throws JsonMappingException, JsonProcessingException {
		logger.info("Accessing submitFeedback method");
		ObjectMapper objmap = new ObjectMapper();
		FeedBackEntity feedback = objmap.readValue(userAnswers, FeedBackEntity.class);

		// Get the userEmail from cookies
		Cookie[] cookies = request.getCookies();
		String userEmail = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("userEmail")) {
					userEmail = cookie.getValue();
					break;
				}
			}
		}

		// Set the userEmail in the feedback entity
		if (userEmail != null) {
			UserEntity user = new UserEntity();
			user.setUserEmail(userEmail);
			feedback.setUserEmail(user);
			feedBackServices.addFeedBack(feedback);
			FeedBackEntity feedback1 = feedBackServices.viewFeedBack(userEmail);
			Cookie userCode = new Cookie("userCode", Integer.toString(feedback1.getFeedBackId()));
			userCode.setMaxAge(3600);
			response.addCookie(userCode);

		}

		return ResponseEntity.ok("results.html");

	}

	@GetMapping("/viewFeedbackbyEmail")
	@ResponseBody
	public String viewFeedbackByEmail(HttpServletRequest request) {
		logger.info("Accessing viewFeedbackByEmail method");

		StringBuilder feedback = new StringBuilder();
		feedback.append("<h1>View answers by email</h1>");
		feedback.append("<table border='1px'>");
		feedback.append(
				"<tr><th>UserName</th><th>Answer 1</th><th>Answer 2</th><th>Answer 3</th><th>Answer 4</th><th>Answer 5</th></tr>");

		try {
			Cookie[] cookies = request.getCookies();
			String userEmail = null;
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("userEmail")) {
						userEmail = cookie.getValue();
						break;
					}
				}
			}

			if (userEmail != null) {
				FeedBackEntity user = feedBackServices.viewFeedBack(userEmail);

				feedback.append("<tr>");
				feedback.append("<td>").append(user.getUserEmail().getUserName()).append("</td>");
				feedback.append("<td>").append(user.getAnswer1()).append("</td>");
				feedback.append("<td>").append(user.getAnswer2()).append("</td>");
				feedback.append("<td>").append(user.getAnswer3()).append("</td>");
				feedback.append("<td>").append(user.getAnswer4()).append("</td>");
				feedback.append("<td>").append(user.getAnswer5()).append("</td>");
				feedback.append("</tr>");

				// Add button for sending email
				feedback.append("<tr>");
				feedback.append("<td colspan='6'>");
				feedback.append("<button onclick=\"sendEmail('").append(userEmail).append("')\">Send Email</button>");
				feedback.append("</td>");
				feedback.append("</tr>");
			} else {
				feedback.append("<tr><td colspan='6'>No feedback found for the user.</td></tr>");
			}
		} catch (Exception e) {
			logger.error("An error occurred while retrieving feedback details by email", e);
		}

		feedback.append("</table>");
		return feedback.toString();
	}

	@GetMapping("admin/viewFeedback")
	@ResponseBody
	public String viewFeedBack() {
		logger.info("Accessing viewFeedback method");

		StringBuilder feedBack = new StringBuilder();
		feedBack.append("<h1>View all answers</h1>");
		feedBack.append("<table border='1px'>");
		feedBack.append(
				"<tr><th>UserName</th><th>Answer 1</th><th>Answer 2</th><th>Answer 3</th><th>Answer 4</th><th>Answer 5</th></tr>");

		try {
			for (FeedBackEntity feedback : feedBackServices.viewAllFeedBackDetails()) {
				feedBack.append("<tr>");
				feedBack.append("<td>").append(feedback.getUserEmail().getUserName()).append("</td>");
				feedBack.append("<td>").append(feedback.getAnswer1()).append("</td>");
				feedBack.append("<td>").append(feedback.getAnswer2()).append("</td>");
				feedBack.append("<td>").append(feedback.getAnswer3()).append("</td>");
				feedBack.append("<td>").append(feedback.getAnswer4()).append("</td>");
				feedBack.append("<td>").append(feedback.getAnswer5()).append("</td>");
				feedBack.append("</tr>");
			}
		} catch (Exception e) {
			logger.error("An error occurred while retrieving feedback details", e);
		}

		feedBack.append("</table>");
		return feedBack.toString();
	}

	@GetMapping("admin/viewFeedbackbyEmail")
	@ResponseBody
	public String viewFeedbackByEmail(@RequestParam String userEmail) {
		logger.info("Accessing viewFeedbackByEmail method");

		StringBuilder feedBack = new StringBuilder();
		feedBack.append("<h1>View answers by email</h1>");
		feedBack.append("<table border='1px'>");
		feedBack.append(
				"<tr><th>UserName</th><th>Answer 1</th><th>Answer 2</th><th>Answer 3</th><th>Answer 4</th><th>Answer 5</th></tr>");

		try {
			FeedBackEntity user = feedBackServices.viewFeedBack(userEmail);

			feedBack.append("<tr>");
			feedBack.append("<td>").append(user.getUserEmail().getUserName()).append("</td>");
			feedBack.append("<td>").append(user.getAnswer1()).append("</td>");
			feedBack.append("<td>").append(user.getAnswer2()).append("</td>");
			feedBack.append("<td>").append(user.getAnswer3()).append("</td>");
			feedBack.append("<td>").append(user.getAnswer4()).append("</td>");
			feedBack.append("<td>").append(user.getAnswer5()).append("</td>");
			feedBack.append("</tr>");
		} catch (Exception e) {
			logger.error("An error occurred while retrieving feedback details by email", e);
		}

		feedBack.append("</table>");
		return feedBack.toString();
	}

	@GetMapping("/getResult")
	public ResponseEntity<FeedBackEntity> getReport(@CookieValue(value = "userCode") String sid) {
		FeedBackEntity feedback = feedBackServices.viewFeedBackById(Integer.parseInt(sid));
		return ResponseEntity.ok(feedback);
	}
}
