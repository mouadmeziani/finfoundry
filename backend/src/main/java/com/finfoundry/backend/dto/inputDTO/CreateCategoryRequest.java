package com.finfoundry.backend.dto.inputDTO;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCategoryRequest {
    @NotBlank(message = "Category name must not be blank.")
    @Size(max = 100, message = "Category name must be less than 100 characters.")
    private String name;

    @Size(max = 500, message = "Description must be less than 500 characters.")
    private String description;
}