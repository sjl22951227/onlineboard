package com.sjl22951227.onlineboard.User.services;

import com.sjl22951227.onlineboard.User.User;
import com.sjl22951227.onlineboard.User.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.time.LocalDate;

@Service
public class UserAuthServiceImpl implements UserAuthService {

    private final UserRepository userRepository;

    public UserAuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostConstruct
    public void init() {
        if(userRepository.findAll().size()<2){
            User user=new User("master","masterdummy!","ma","ster","master","master@abc.com");
            createUser(user);
        }
    }

    @Override
    public User createUser(User user) {

        User idChecker = userRepository.findByUsername(user.getUsername());
        if (idChecker!=null)
        {
            return null;
        }
        else{
            return userRepository.save(user);
        }

    }


}