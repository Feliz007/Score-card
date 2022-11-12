package com.feliz.scorecard.serviceimpl;

import com.feliz.scorecard.dto.DecadevDto;
import com.feliz.scorecard.dto.responsedto.APIResponse;
import com.feliz.scorecard.exceptions.CustomException;
import com.feliz.scorecard.exceptions.SquadNotFoundException;
import com.feliz.scorecard.exceptions.StackNotFoundException;
import com.feliz.scorecard.model.*;
import com.feliz.scorecard.repository.*;
import com.feliz.scorecard.response.AdminResponse;
import com.feliz.scorecard.service.AdminService;

import java.util.ArrayList;
import java.util.List;

public class AdminServiceImpl implements AdminService {
    private AdminRepository adminRepository;

    private UserRepository userRepository;

    private PodRepository podRepository;

    private StackRepository stackRepository;

    private SquadRepository squadRepository;

    @Override
    public List<AdminResponse> getAllAdmin() {
        List<Admin> admins = adminRepository.findAll();
        List<AdminResponse> adminResponses = new ArrayList<>();
        if (admins.size() != 0){
            for (Admin admin : admins){
                adminResponses.add(new AdminResponse(admin));
            }
        }
        return adminResponses;
    }

    @Override
    public User createDecadev(DecadevDto decadev, Long podId, Long stackId, Long squadId) {
        if(userRepository.findByEmail(decadev.getEmail()).isPresent()){
            throw new CustomException("User email already exist");
        }
        Pod pod = podRepository.findById(podId).orElseThrow(()-> new CustomException("Not found"));
        Stack stack = stackRepository.findById(stackId).orElseThrow(()-> new StackNotFoundException("Not found"));
        Squad squad = squadRepository.findById(squadId).orElseThrow(()-> new SquadNotFoundException("Not found"));
        Decadev dev = new Decadev();
        dev.setFirstName(decadev.getFirstName());
        dev.setLastName(decadev.getLastName());
        dev.setGender(decadev.getGender());
        dev.setEmail(decadev.getEmail());
        dev.setDecadevId(decadev.getDecadevId());
        dev.setRole(decadev.getRole());
        dev.setSquad(squad);
        dev.setStack(stack);
        dev.setPod(pod);

        return userRepository.save(dev);

    }

    @Override
    public APIResponse<Decadev> updateDecadev(DecadevDto decadevDto, Long decadevId, Long podId, Long stackId, Long squadId ) {
        Decadev decadev = (Decadev) userRepository.findById(decadevId).orElseThrow(() -> new CustomException("Decadev not found"));
        Pod pod = podRepository.findById(podId).orElseThrow(()-> new CustomException("Not found"));
        Stack stack = stackRepository.findById(stackId).orElseThrow(()-> new StackNotFoundException("Not found"));
        Squad squad = squadRepository.findById(squadId).orElseThrow(()-> new SquadNotFoundException("Not found"));
        decadev.setFirstName(decadevDto.getFirstName());
        decadev.setLastName(decadevDto.getLastName());
        decadev.setEmail(decadevDto.getEmail());
        decadev.setSquad(squad);
        decadev.setStack(stack);
        decadev.setPod(pod);
        userRepository.save(decadev);
        return new APIResponse<>(true, "Decadev updated successfully", decadev);

    }
}
