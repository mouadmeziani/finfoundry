package com.finfoundry.backend.repository;

import com.finfoundry.backend.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.time.LocalDate;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUserId(Long userId);
    List<Transaction> findByDateBetween(LocalDate startDate, LocalDate endDate);
}