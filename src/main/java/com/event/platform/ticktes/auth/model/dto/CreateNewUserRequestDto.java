package com.event.platform.ticktes.auth.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateNewUserRequestDto {

    @Email(message = "Invalid Email Format")
    @NotBlank(message = "Email is Required")
    private String email;

    @NotBlank(message = "Password Can't be empty")
    @Size(min = 8,message = "Password must contain 8 characters")
    private String password;
}
