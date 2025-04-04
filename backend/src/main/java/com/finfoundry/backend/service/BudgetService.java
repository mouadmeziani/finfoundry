package com.finfoundry.backend.service;

import com.finfoundry.backend.model.Budget;
import com.finfoundry.backend.repository.BudgetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BudgetService {
    private final BudgetRepository budgetRepository;

    @Transactional
    public Budget createBudget(Budget budget) {
        if (budget.getTotalBudget().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Total budget must be positive.");
        }
        return budgetRepository.save(budget);
    }

    public List<Budget> getBudgetsByUser(Long userId) {
        return budgetRepository.findByUserId(userId);
    }
}