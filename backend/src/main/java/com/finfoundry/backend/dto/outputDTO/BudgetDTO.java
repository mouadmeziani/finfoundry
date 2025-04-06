package com.finfoundry.backend.dto.outputDTO;

import lombok.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BudgetDTO {
    private Long id;
    private Long userId;
    private String period;  // "monthly" or "annual"
    private BigDecimal totalBudget;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}