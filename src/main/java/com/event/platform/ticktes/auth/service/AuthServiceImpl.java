package com.event.platform.ticktes.auth.service;

import com.event.platform.ticktes.security.JwtService;
import com.event.platform.ticktes.user.model.User;
import com.event.platform.ticktes.user.service.UserService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Builder
public class AuthServiceImpl implements AuthService {
    private final JwtService jwtService;
    private final UserService userService;

    @Override
    public String CreateUser(User user) {
        User createdUser = userService.createNewUser(user);
        return null;//jwtService.generateToken(createdUser.getEmail());
    }
}
