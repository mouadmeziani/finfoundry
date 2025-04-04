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
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tag name must not be blank.")
    @Size(max = 50, message = "Tag name must be less than 50 characters.")
    @Column(nullable = false, length = 50, unique = true)
    private String name;
}