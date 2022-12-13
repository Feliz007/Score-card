package com.feliz.scorecard.service;

import com.feliz.scorecard.dto.*;
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

    User CreateAdmin(AdminDto adminDto);

    String createSquad(SquadDto squadDto);

    APIResponse getAdmin(Long id);

    Page<Squad> getAllSquads(int offset, int pageSize);

    List<StackResponseDto> getDetailsOfAllStacks(Long squadId);

    Stack getStackUsingId(Long id);

    APIResponse<String> updateStack(StackDto stackDto, Long id);
    APIResponse<Admin> updateAdmin(AdminDto adminDto, Long adminId);

    APIResponse<User>activateAdmin(Long adminId);
    APIResponse<User> deactivateAdmin(Long adminId);

    Pod getPod(Long id);

    APIResponse<?> forgotPassword(ForgetPasswordRequest request);

    APIResponse<?> resetPassword(ResetPasswordRequest request);


    APIResponse<?> changePassword(ChangePasswordRequest request, String email);

    List<PodResponseDto> getAllPodsInAStack(Long stackId);
}

