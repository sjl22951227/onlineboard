package com.sjl22951227.onlineboard.User.services;

import com.sjl22951227.onlineboard.User.User;
import com.sjl22951227.onlineboard.User.repository.UserRepository;
import com.sjl22951227.onlineboard.jwt.JwtSecurityConfig;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository, JwtSecurityConfig jwtSecurityConfig) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("User not found!");
        }

        return null;
    }
}
