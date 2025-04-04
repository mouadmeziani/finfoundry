package com.finfoundry.backend.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name must not be blank.")
    @Size(max = 100, message = "Name must be less than 100 characters.")
    @Column(nullable = false, length = 100)
    private String name;

    @NotBlank(message = "Email must not be blank.")
    @Email(message = "Email must be valid.")
    @Size(max = 255)
    @Column(nullable = false, length = 255, unique = true)
    private String email;

    @NotBlank(message = "Password must not be blank.")
    @Size(min = 6, message = "Password must be at least 6 characters.")
    @Column(nullable = false, length = 255)
    private String password;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    private OffsetDateTime updatedAt;
}