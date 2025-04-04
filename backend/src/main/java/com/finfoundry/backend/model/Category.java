package com.finfoundry.backend.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Category name must not be blank.")
    @Size(max = 100, message = "Category name must be less than 100 characters.")
    @Column(nullable = false, length = 100, unique = true)
    private String name;

    @Size(max = 500, message = "Description must be less than 500 characters.")
    @Column(columnDefinition = "TEXT")
    private String description;
}
