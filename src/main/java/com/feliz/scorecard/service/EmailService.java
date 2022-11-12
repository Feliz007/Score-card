package com.feliz.scorecard.service;



public interface EmailService {


    boolean sendEmail(String body, String subject, String email);
}

