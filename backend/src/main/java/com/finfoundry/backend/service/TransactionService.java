package com.finfoundry.backend.service;

import com.finfoundry.backend.dto.inputDTO.CreateTransactionRequest;
import com.finfoundry.backend.dto.outputDTO.TransactionDTO;
import com.finfoundry.backend.mapper.TransactionMapper;
import com.finfoundry.backend.model.Category;
import com.finfoundry.backend.model.Tag;
import com.finfoundry.backend.model.Transaction;
import com.finfoundry.backend.model.User;
import com.finfoundry.backend.port.CategoryRepositoryPort;
import com.finfoundry.backend.port.TagRepositoryPort;
import com.finfoundry.backend.port.TransactionRepositoryPort;
import com.finfoundry.backend.port.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionMapper transactionMapper;
    private final UserRepositoryPort userRepositoryPort;
    private final CategoryRepositoryPort categoryRepositoryPort;
    private final TagRepositoryPort tagRepositoryPort;
    private final TransactionRepositoryPort transactionRepositoryPort;

    @Transactional(readOnly = true)
    public List<TransactionDTO> getTransactionsByUser(Long userId) {
        List<Transaction> transactions = transactionRepositoryPort.findByUserId(userId);

        List<TransactionDTO> transactionDTOs = transactions.stream()
                .map(transactionMapper::toTransactionDTO)
                .collect(Collectors.toList());

        return transactionDTOs;
    }
    @Transactional
    public TransactionDTO createTransaction(CreateTransactionRequest request) {
        Transaction transaction = transactionMapper.fromCreateTransactionRequest(request);
        if (transaction.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Transaction amount must be positive.");
        }
        User user = userRepositoryPort.findById(request.getUserId()).orElseThrow(() -> new IllegalArgumentException("User not found."));
        transaction.setUser(user);

        if(request.getCategoryId() != null) {
            Category category = categoryRepositoryPort.findById(request.getCategoryId()).orElseThrow(() -> new IllegalArgumentException("Category not found."));
            transaction.setCategory(category);
        }
        if(request.getTagIds() != null && !request.getTagIds().isEmpty()) {
            Set<Tag> tags = request.getTagIds().stream()
                    .map(id -> tagRepositoryPort.findById(id)
                            .orElseThrow(() -> new IllegalArgumentException("Tag not found: " + id)))
                    .collect(Collectors.toSet());
            transaction.setTags(tags);
        }
        return transactionMapper.toTransactionDTO(transactionRepositoryPort.save(transaction));
    }
}
