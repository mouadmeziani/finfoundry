package com.finfoundry.backend.dto.inputDTO;

import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTransactionRequest {
    @NotNull(message = "User ID is required.")
    private Long userId;

    @NotNull(message = "Amount is required.")
    @DecimalMin(value = "0.01", inclusive = true, message = "Amount must be at least 0.01.")
    private BigDecimal amount;

    @Size(max = 1000, message = "Description must be less than 1000 characters.")
    private String description;

    @NotNull(message = "Date is required.")
    private LocalDate date;

    @NotBlank(message = "Transaction type is required.")
    private String type;  // "income" or "expense"

    // Optional fields (if provided)
    private Long categoryId;
    private Set<Long> tagIds;
}