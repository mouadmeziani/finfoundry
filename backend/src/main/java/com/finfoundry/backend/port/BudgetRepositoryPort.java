package com.finfoundry.backend.port;

import com.finfoundry.backend.model.Budget;
import java.util.List;

public interface BudgetRepositoryPort {
    Budget save(Budget budget);
    List<Budget> findByUserId(Long userId);
}