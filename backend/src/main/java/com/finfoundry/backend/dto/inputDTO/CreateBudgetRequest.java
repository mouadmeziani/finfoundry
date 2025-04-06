package com.finfoundry.backend.dto.inputDTO;


import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateBudgetRequest {
    @NotNull(message = "User ID is required.")
    private Long userId;

    @NotBlank(message = "Budget period is required.")
    private String period; // "monthly" or "annual"

    @NotNull(message = "Total budget is required.")
    @DecimalMin(value = "0.01", inclusive = true, message = "Total budget must be at least 0.01.")
    private BigDecimal totalBudget;
}