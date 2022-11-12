package com.feliz.scorecard.serviceimpl;

import com.feliz.scorecard.model.Admin;
import com.feliz.scorecard.repository.AdminRepository;
import com.feliz.scorecard.repository.UserRepository;
import com.feliz.scorecard.response.AdminResponse;
import com.feliz.scorecard.service.AdminService;

import java.util.ArrayList;
import java.util.List;

public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    private final UserRepository userRepository;
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
}
