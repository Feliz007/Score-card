package com.feliz.scorecard.service;

import com.feliz.scorecard.dto.StackDto;
import com.feliz.scorecard.dto.responsedto.APIResponse;
import com.feliz.scorecard.model.StackTemplate;

public interface StackService {

      APIResponse <StackTemplate> createStack(StackDto stackDto);

}
