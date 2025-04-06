package com.finfoundry.backend.mapper;

import com.finfoundry.backend.dto.outputDTO.CategoryDTO;
import com.finfoundry.backend.dto.inputDTO.CreateCategoryRequest;
import com.finfoundry.backend.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTO toCategoryDTO(Category category);
    Category fromCreateCategoryRequest(CreateCategoryRequest request);
}