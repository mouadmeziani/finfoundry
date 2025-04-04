package com.finfoundry.backend.adapter;

import com.finfoundry.backend.model.Transaction;
import com.finfoundry.backend.repository.TransactionRepository;
import com.finfoundry.backend.port.TransactionRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TransactionRepositoryAdapter implements TransactionRepositoryPort {
    private final TransactionRepository transactionRepository;
    @Override
    public List<Transaction> findByUserId(Long userId) {
        return transactionRepository.findByUserId(userId);
    }

    @Override
    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
