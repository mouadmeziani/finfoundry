package com.finfoundry.backend.port;

import com.finfoundry.backend.model.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryRepositoryPort {
    Category save(Category category);
    Optional<Category> findById(Long id);
    List<Category> findAll();
}