//package com.exterro.feedbackquestion.controller;
//
//import com.exterro.feedbackquestion.request.EmailRequest;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.io.IOException;
//
//@Controller
//public class EmailController {
//
//    private final JavaMailSender javaMailSender;
//
//    @Autowired
//    public EmailController(JavaMailSender javaMailSender) {
//        this.javaMailSender = javaMailSender;
//    }
//
//    @PostMapping(path ="sendEmail")
//    @ResponseBody
//    public ResponseEntity<String> sendEmail(@RequestBody String emailAnswers) {
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            EmailRequest emailRequest = objectMapper.readValue(emailAnswers, EmailRequest.class);
//            String recipientEmail = emailRequest.getUserEmail();
//            String subject = "Results email";
//            String body = "body";
//            System.out.println("@@@@@@@@@@@@@@@@@@@"+recipientEmail);
//
//            if (recipientEmail == null || subject == null || body == null) {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing email details.");
//            }
//
//            SimpleMailMessage message = new SimpleMailMessage();
//            message.setTo(recipientEmail);
//            message.setSubject(subject);
//            message.setText(body);
//            javaMailSender.send(message);
//            return ResponseEntity.ok("emailsuccessfull.html");
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid email data format.");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email.");
//        }
//    }
//}
