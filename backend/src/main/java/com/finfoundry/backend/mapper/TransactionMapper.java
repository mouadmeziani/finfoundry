package com.finfoundry.backend.mapper;

import com.finfoundry.backend.dto.inputDTO.CreateTransactionRequest;
import com.finfoundry.backend.dto.outputDTO.TransactionDTO;
import com.finfoundry.backend.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, TagMapper.class})
public interface TransactionMapper {

    // Map the Transaction entity to DTO. Nested objects are mapped using CategoryMapper and TagMapper.
    TransactionDTO toTransactionDTO(Transaction transaction);

    // Create a Transaction from a CreateTransactionRequest.
    // We ignore the id as it's generated, and the mapping for nested objects (category, tags) might require additional logic.
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true) // set in service layer after looking up the User entity by id
    @Mapping(target = "category", ignore = true) // likewise, set this based on request.categoryId if provided
    @Mapping(target = "tags", ignore = true) // set based on request.tagIds if provided
    Transaction fromCreateTransactionRequest(CreateTransactionRequest request);
}