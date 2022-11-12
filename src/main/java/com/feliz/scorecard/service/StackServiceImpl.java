package com.feliz.scorecard.service;

import com.feliz.scorecard.dto.StackDto;
import com.feliz.scorecard.dto.responsedto.APIResponse;
import com.feliz.scorecard.model.StackTemplate;
import com.feliz.scorecard.repository.StackTemplateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StackServiceImpl implements StackService{

    private final StackTemplateRepository stackTemplateRepository;

    @Override
    public APIResponse <StackTemplate> createStack(StackDto stackDto) {

       StackTemplate  stack = stackTemplateRepository.findByStackNameIgnoreCase(stackDto.getStackName());
        if (stack == null) {
            StackTemplate newStack = new StackTemplate();
            newStack.setStackName(stackDto.getStackName());
            stackTemplateRepository.save(newStack);
            return new APIResponse<>(true,"Stack Successfully Created",newStack);
        }else{
            return new APIResponse<>(true,"Stack already exist");

        }

    }


}
