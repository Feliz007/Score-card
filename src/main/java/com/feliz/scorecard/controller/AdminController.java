package com.feliz.scorecard.controller;

import com.feliz.scorecard.dto.DecadevDto;
import com.feliz.scorecard.dto.WeeklyScoreDto;
import com.feliz.scorecard.dto.responsedto.APIResponse;
import com.feliz.scorecard.model.User;
import com.feliz.scorecard.model.WeeklyScore;
import com.feliz.scorecard.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;


    @PostMapping("/create-decadev/{squadId}/{stackId}/{podId}")
    public ResponseEntity<APIResponse<?>> createDecadev(@RequestBody DecadevDto decadevDto, @PathVariable("podId") Long podId, @PathVariable("stackId") Long stackId, @PathVariable("squadId") Long squadId) {
            User dev = adminService.createDecadev(decadevDto, podId, stackId, squadId);
            return new ResponseEntity<>(new APIResponse<>(true, "decadev created successfully", dev), HttpStatus.CREATED);

    }

    @PutMapping("/update-decadev/{squadId}/{stackId}/{podId}")
    public ResponseEntity<APIResponse<?>> updateDecadev(@RequestBody DecadevDto decadevDto, @PathVariable("podId") Long podId, @PathVariable("stackId") Long stackId, @PathVariable("squadId") Long squadId) {
        User dev = adminService.createDecadev(decadevDto, podId, stackId, squadId);
        return new ResponseEntity<>(new APIResponse<>(true, "Decadev updated successfully", dev), HttpStatus.CREATED);

    }

    @DeleteMapping("/delete-decadev/{id}")
    public ResponseEntity<APIResponse<?>> deleteDecadev(@PathVariable("id") Long id) {
        try {
            adminService.deleteDecadev(id);
            return new ResponseEntity<>(new APIResponse<>(true, "decadev deleted successfully", null), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new APIResponse<>(false, e.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/weekly-score/{devId}")
    public ResponseEntity<APIResponse<?>> weeklyScore(@PathVariable("devId") Long devId, @RequestBody WeeklyScoreDto score) {
        try {
            WeeklyScore devScore = adminService.decadevWeeklyScore(score, devId);
            return new ResponseEntity<>(new APIResponse<>(true, "Weekly score populated successfully", devScore), HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(new APIResponse<>(false, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
        }

    }
    @PutMapping("/update-score/{devId}/weekly-score/{weekId}")
    public ResponseEntity<APIResponse<?>> updateScore(@PathVariable("devId") Long devId,@PathVariable("weekId") Long weekId, @RequestBody WeeklyScoreDto score) {
        WeeklyScore devScore = adminService.updateDecadevWeeklyScore(score, devId, weekId);
        return new ResponseEntity<>(new APIResponse<>(true, "Succesfully updated your score", devScore), HttpStatus.OK);
    }

    @GetMapping("/getScore/{week}/{dev_id}")
    public ResponseEntity<APIResponse<?>> getDevScore(@PathVariable("week")String week, @PathVariable("dev_id")Long dev_id){
        WeeklyScore devScore = adminService.getDevWeeklyScore(week,dev_id);
        return new ResponseEntity<>(new APIResponse<>(true,"Dev Weekly Score", devScore), HttpStatus.OK);
    }

    @GetMapping("/get-all-decadevs/{podId}")
    public ResponseEntity<APIResponse<?>> getAllDecadevs(@PathVariable("podId") Long podId) {
        List<DecadevDto> decadevs = adminService.getAllDecadevsFromAPod(podId);
        return new ResponseEntity<>(new APIResponse<>(true, "decadevs retrieved successfully", decadevs), HttpStatus.OK);

    }

}
