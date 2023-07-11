package com.exterro.feedbackquestion.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import com.exterro.feedbackquestion.services.JpaUserDetailsService;

@Configuration
public class SecurityConfig {
    private final JpaUserDetailsService myUserDetailsService;

    public SecurityConfig(JpaUserDetailsService myUserDetailsService) {
        this.myUserDetailsService = myUserDetailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeRequests().requestMatchers("/home", "/feed","/getResult").permitAll()
                .and()
                .authorizeRequests().requestMatchers("/admin/**").hasAnyRole("ADMIN").anyRequest().authenticated()
                .and()
                .userDetailsService(myUserDetailsService)
                .formLogin()
                .and()
                .build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/feedback.html", "/script/feedbackquestion.js", "/submitFeedback", "/giveFeedback","/submitRegistration", "/questions.html","/feedbackForm","/results.html","/viewFeedbackbyEmail","/getCookies","/getResult","/getEmail","/emailsuccessfull.html");
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new MessageDigestPasswordEncoder("SHA-256");
    }
}
