package com.finfoundry.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "Transaction must be associated with a user.")
    private User user;

    @NotNull(message = "Transaction amount is required.")
    @DecimalMin(value = "0.01", inclusive = true, message = "Amount must be at least 0.01.")
    @Digits(integer = 10, fraction = 2, message = "Invalid amount format.")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Size(max = 1000, message = "Description must be less than 1000 characters.")
    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category")
    private Category category;

    @NotNull(message = "Date is required.")
    @Column(nullable = false)
    private LocalDate date;

    @NotNull(message = "Transaction type is required.")
    @Column(nullable = false, length = 19)
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @ManyToMany
    @JoinTable(
            name = "transaction_tags",
            joinColumns = @JoinColumn(name = "transaction_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    @Builder.Default
    private Set<Tag> tags = new HashSet<>();
}
