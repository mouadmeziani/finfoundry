package com.finfoundry.backend.service;

import com.finfoundry.backend.model.Transaction;
import com.finfoundry.backend.port.TransactionRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepositoryPort transactionRepositoryPort;

    public List<Transaction> getTransactionsByUser(Long userId) {
        return transactionRepositoryPort.findByUserId(userId);
    }
    @Transactional
    public Transaction createTransaction(Transaction transaction) {
        if (transaction.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Transaction amount must be positive.");
        }
        if (transaction.getUser() == null) {
            throw new IllegalArgumentException("Transaction must be associated with a user.");
        }

        return transactionRepositoryPort.save(transaction);
    }
}
