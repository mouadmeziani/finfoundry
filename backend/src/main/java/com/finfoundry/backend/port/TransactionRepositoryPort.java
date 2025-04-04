package com.finfoundry.backend.port;

import com.finfoundry.backend.model.Transaction;

import java.util.List;

public interface TransactionRepositoryPort {
    List<Transaction> findByUserId(Long userId);
    Transaction save(Transaction transaction);
}
