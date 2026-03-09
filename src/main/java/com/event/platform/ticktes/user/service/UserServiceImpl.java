package com.event.platform.ticktes.user.service;

import com.event.platform.ticktes.exception.custome.UserNotFoundException;
import com.event.platform.ticktes.user.model.User;
import com.event.platform.ticktes.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    @Override
    public User createNewUser(User user) {
        if (userRepository.existByEmail(user.getEmail())){
            throw new UserNotFoundException("User Already Exist with this email: "+  user.getEmail());
        }
        User createUser = userRepository.save(user);
        return createUser;
    }
}
