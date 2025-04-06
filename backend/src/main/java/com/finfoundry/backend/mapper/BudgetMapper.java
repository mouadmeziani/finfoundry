package com.finfoundry.backend.mapper;


import com.finfoundry.backend.dto.outputDTO.BudgetDTO;
import com.finfoundry.backend.dto.inputDTO.CreateBudgetRequest;
import com.finfoundry.backend.model.Budget;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BudgetMapper {
    BudgetDTO toBudgetDTO(Budget budget);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true) // will be set in service layer based on userId
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Budget fromCreateBudgetRequest(CreateBudgetRequest request);
}