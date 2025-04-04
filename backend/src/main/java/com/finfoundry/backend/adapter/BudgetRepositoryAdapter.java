package com.finfoundry.backend.adapter;

import com.finfoundry.backend.model.Budget;
import com.finfoundry.backend.port.BudgetRepositoryPort;
import com.finfoundry.backend.repository.BudgetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BudgetRepositoryAdapter implements BudgetRepositoryPort {

    private final BudgetRepository budgetRepository;

    @Override
    public Budget save(Budget budget) {
        return budgetRepository.save(budget);
    }

    @Override
    public List<Budget> findByUserId(Long userId) {
        return budgetRepository.findByUserId(userId);
    }
}