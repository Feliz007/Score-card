package com.feliz.scorecard.service;

import com.feliz.scorecard.dto.requestdto.LoginDto;
import com.feliz.scorecard.dto.responsedto.LoginResponse;

public interface AuthService{
    LoginResponse login(LoginDto loginDto) throws Exception;
}
