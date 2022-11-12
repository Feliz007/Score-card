package com.feliz.scorecard.service;

import com.feliz.scorecard.dto.StackDto;
import com.feliz.scorecard.dto.requestdto.AdminDto;
import com.feliz.scorecard.dto.responsedto.APIResponse;
import com.feliz.scorecard.dto.responsedto.SquadDto;
import com.feliz.scorecard.dto.responsedto.StackResponseDto;
import com.feliz.scorecard.model.*;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SuperAdminService {

    List<Pod> listOfPods();

    String removeAdminById(Long id);

    User CreateAdmin(AdminDto adminDto, Long podId, Long stackId, Long squadId);

    String createSquad(SquadDto squadDto);

    APIResponse getAdmin(Long id);

    Page<Squad> getAllSquads(int offset, int pageSize);

    List<StackResponseDto> getDetailsOfAllStacks(Long squadId);

    Stack getStackUsingId(Long id);

    APIResponse<String> updateStack(StackDto stackDto, Long id);
    APIResponse<Admin> updateAdmin(AdminDto adminDto, Long adminId);

    APIResponse<User>activateAdmin(Long adminId);
    APIResponse<User> deactivateAdmin(Long adminId);


}

