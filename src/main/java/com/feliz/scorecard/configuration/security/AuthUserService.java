package com.feliz.scorecard.configuration.security;

import com.feliz.scorecard.exceptions.AccountNotActiveException;
import com.feliz.scorecard.model.CustomUserDetail;
import com.feliz.scorecard.model.User;
import com.feliz.scorecard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthUserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException(
                email + " was not found"));
       if(user.getIsAccountActive()) {
           return new CustomUserDetail(user);
       }else
           throw new AccountNotActiveException("User account is not active");

    }
}


