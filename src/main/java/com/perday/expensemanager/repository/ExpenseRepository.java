package com.perday.expensemanager.repository;

import com.perday.expensemanager.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByExpensePaidDateTimeBetween(LocalDateTime startDate, LocalDateTime endDate);
    List<Expense> findByCategory(String category);
}
