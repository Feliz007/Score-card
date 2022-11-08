package com.feliz.scorecard.utility;

import com.feliz.scorecard.enums.Gender;
import com.feliz.scorecard.enums.Role;
import com.feliz.scorecard.model.SuperAdmin;
import com.feliz.scorecard.model.User;
import com.feliz.scorecard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class DataLoader {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Value("${admin.password:password}")
    private String adminPassword;
    @Value("${super.email:email}")
    private String adminEmail;

    @Bean
    public CommandLineRunner preloadAdmin() {
        User user = userRepository.findFirstByRole(Role.SUPERADMIN).orElse(null);
        if (user == null) {
            return args -> {
                SuperAdmin user1 = new SuperAdmin("Felix", "Elemele", Gender.MALE, adminEmail, Role.SUPERADMIN, passwordEncoder.encode(adminPassword),true);
                userRepository.save(user1);
            };
        }
        return null;
    }
}