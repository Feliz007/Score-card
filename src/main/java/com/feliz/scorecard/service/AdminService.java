package com.feliz.scorecard.service;

import com.feliz.scorecard.dto.DecadevDto;
import com.feliz.scorecard.dto.responsedto.APIResponse;
import com.feliz.scorecard.model.Decadev;
import com.feliz.scorecard.model.User;
import com.feliz.scorecard.response.AdminResponse;

import java.util.List;

public interface AdminService {
    List<AdminResponse> getAllAdmin();

    User createDecadev(DecadevDto dev, Long podId, Long stackId, Long squadId);

    APIResponse<Decadev> updateDecadev(DecadevDto decadevDto, Long decadevId, Long podId, Long stackId, Long squadId);
}
