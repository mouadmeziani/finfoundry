package com.finfoundry.backend.model;



import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "budgets")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "Budget must be associated with a user.")
    private User user;

    @NotNull(message = "Budget period is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private BudgetPeriod period;

    @NotNull(message = "Total budget is required.")
    @DecimalMin(value = "0.01", inclusive = true, message = "Total budget must be at least 0.01.")
    @Digits(integer = 10, fraction = 2, message = "Invalid total budget format.")
    @Column(name = "total_budget", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalBudget;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    private OffsetDateTime updatedAt;
}