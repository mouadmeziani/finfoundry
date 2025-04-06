package com.finfoundry.backend.dto.inputDTO;


import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTagRequest {
    @NotBlank(message = "Tag name must not be blank.")
    @Size(max = 50, message = "Tag name must be less than 50 characters.")
    private String name;
}