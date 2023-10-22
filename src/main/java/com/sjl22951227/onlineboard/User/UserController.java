package com.sjl22951227.onlineboard.User;

import com.sjl22951227.onlineboard.User.repository.UserRepository;
import com.sjl22951227.onlineboard.User.services.UserAuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserAuthService userAuthService;

    public UserController(UserAuthService userAuthService) {
        this.userAuthService = userAuthService;
    }


    @PostMapping("/auth/signup")
    public ResponseEntity<User> createUsers(@RequestBody User user) {
        User newUser = userAuthService.createUser(user);
        if (newUser == null) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        }
    }
}