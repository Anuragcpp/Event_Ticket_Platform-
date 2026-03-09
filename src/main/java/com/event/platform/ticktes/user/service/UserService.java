package com.event.platform.ticktes.user.service;

import com.event.platform.ticktes.user.model.User;

public interface UserService {
    public User createNewUser(User user);

    public User loadUserByUserName(String userName);
}
