package com.sjl22951227.onlineboard.User.services;

import com.sjl22951227.onlineboard.User.User;

public interface UserAuthService {
    void init();

    User createUser(User user);
}
