package com.event.platform.ticktes.auth.controller;

import com.event.platform.ticktes.auth.model.dto.CreateNewUserRequestDto;
import com.event.platform.ticktes.auth.service.AuthService;
import com.event.platform.ticktes.auth.service.AuthServiceImpl;
import com.event.platform.ticktes.user.mapper.UserMapper;
import com.event.platform.ticktes.user.model.User;
import com.event.platform.ticktes.user.model.dto.UserDto;
import com.event.platform.ticktes.user.service.UserService;
import com.event.platform.ticktes.util.model.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController  {

    private final AuthService authService;
    private final UserMapper userMapper;


    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<String >> SignUpUser(
            @Valid @RequestBody CreateNewUserRequestDto createNewUserRequestDto
            ) {
        String token = authService.CreateUser(userMapper.createUserDtoToUserEntity(createNewUserRequestDto));
        return new ResponseEntity<>(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "User Created Successfully",
                        token
                ),
                HttpStatus.OK
        );

    }

}
