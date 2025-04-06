package com.finfoundry.backend.dto.inputDTO;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserRequest {
    @NotBlank(message = "Name must not be blank.")
    @Size(max = 100, message = "Name must be less than 100 characters.")
    private String name;

    @NotBlank(message = "Email must not be blank.")
    @Email(message = "Email must be valid.")
    @Size(max = 255)
    private String email;

    @NotBlank(message = "Password must not be blank.")
    @Size(min = 6, message = "Password must be at least 6 characters.")
    private String password;
}
