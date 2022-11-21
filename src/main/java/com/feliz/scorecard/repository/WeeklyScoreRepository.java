package com.feliz.scorecard.repository;

import com.feliz.scorecard.model.Decadev;
import com.feliz.scorecard.model.WeeklyScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeeklyScoreRepository extends JpaRepository<WeeklyScore,Long> {
    WeeklyScore findWeeklyScoreByWeekAndDecadev(String week, Decadev decadev);
    List<WeeklyScore> findWeeklyScoresByDecadev(Decadev decadev);
}
