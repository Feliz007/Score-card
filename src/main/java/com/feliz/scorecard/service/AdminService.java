package com.feliz.scorecard.service;

import com.feliz.scorecard.dto.DecadevDto;
import com.feliz.scorecard.dto.WeeklyScoreDto;
import com.feliz.scorecard.dto.responsedto.APIResponse;
import com.feliz.scorecard.model.Decadev;
import com.feliz.scorecard.model.WeeklyScore;
import com.feliz.scorecard.response.AdminResponse;

import java.util.List;


public interface AdminService {
    List<AdminResponse> getAllAdmin();

    WeeklyScore decadevWeeklyScore(WeeklyScoreDto weeklyScoreDto, Long id);

   void deleteDecadev(Long decadevId);

    WeeklyScore updateDecadevWeeklyScore(WeeklyScoreDto score, Long Id, Long weekId);


    String createDecadev(DecadevDto dev, Long podId, Long stackId, Long squadId);
    APIResponse<Decadev> updateDecadev(DecadevDto decadevDto, Long decadevId, Long podId, Long stackId, Long squadId);

    WeeklyScore getDevWeeklyScore(String week, Long id);
    List<DecadevDto> getAllDecadevsFromAPod(Long podId);
}
