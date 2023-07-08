//package com.exterro.feedbackquestion.controller;
//
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.exterro.feedbackquestion.request.EmailRequest;
//import com.exterro.feedbackquestion.services.EmailSenderService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@RestController
//public class SendEmailController {
//
//    private final EmailSenderService emailSenderService;
//
//    @Autowired
//    public SendEmailController(EmailSenderService emailSenderService) {
//        this.emailSenderService = emailSenderService;
//    }
//
//    @PostMapping("/sendEmail")
//    public ResponseEntity<String> sendEmail(@RequestBody String emailAnswers) {
//        try {
//        	ObjectMapper objectMapper = new ObjectMapper();
//         EmailRequest emailRequest = objectMapper.readValue(emailAnswers, EmailRequest.class);
//            //  String recipientEmail = emailRequest.getUserEmail();
//              String subject = "Results email";
//              String body = "body";
//              System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@"+emailRequest.getUserEmail());
//            //emailSenderService.sendSimpleEmail(recipientEmail, subject,body);
//            return ResponseEntity.ok("Email sent successfully!");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email.");
//        }
//    }
//}
//
