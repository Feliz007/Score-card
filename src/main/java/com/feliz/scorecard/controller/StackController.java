package com.feliz.scorecard.controller;


import com.feliz.scorecard.dto.StackDto;
import com.feliz.scorecard.dto.responsedto.APIResponse;
import com.feliz.scorecard.model.Stack;
import com.feliz.scorecard.model.StackTemplate;
import com.feliz.scorecard.service.StackService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class StackController {

    private final StackService stackService;

    @PostMapping("/super-admin/create-stack-template")
    public ResponseEntity<APIResponse<StackTemplate>> createStackTemplate(@RequestBody StackDto stackdto) {
        APIResponse<StackTemplate> stack = stackService.createStackTemplate(stackdto);
        return new ResponseEntity<>(stack, HttpStatus.CREATED);
    }

    @PostMapping("/super-admin/{squadId}/create-stack")
    public ResponseEntity<APIResponse<Stack>> createStack(@PathVariable Long squadId,
                                                          @RequestBody StackDto stackDto ){
        return new ResponseEntity<>(stackService.createStack(squadId,stackDto),HttpStatus.CREATED);
    }
}
