package com.feliz.scorecard.service;

import com.feliz.scorecard.dto.StackDto;
import com.feliz.scorecard.dto.responsedto.APIResponse;
import com.feliz.scorecard.model.Stack;
import com.feliz.scorecard.model.StackTemplate;

public interface StackService {

      APIResponse <StackTemplate> createStackTemplate(StackDto stackDto);
      APIResponse<Stack> createStack(long squadId, StackDto stackDto);
}
