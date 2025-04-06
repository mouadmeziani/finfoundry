package com.finfoundry.backend.dto.outputDTO;


import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDTO {
    private Long id;
    private BigDecimal amount;
    private String description;
    private LocalDate date;
    private String type;  // "income" or "expense"
    private CategoryDTO category;  // optional, if present
    private Set<TagDTO> tags;
}