package com.event.platform.ticktes.user.service;

import com.event.platform.ticktes.exception.custome.UserNotFoundException;
import com.event.platform.ticktes.user.model.User;
import com.event.platform.ticktes.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Builder
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    @Override
    public User createNewUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())){
            throw new UserNotFoundException("User Already Exist with this email: "+  user.getEmail());
        }
        //user.setPassword(PasswordEncoder.encord());
        User createUser = userRepository.save(user);
        return createUser;
    }

    @Override
    public User loadUserByUserName(String userName) {
        return null;
    }

    @Override
    public boolean userExistByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
