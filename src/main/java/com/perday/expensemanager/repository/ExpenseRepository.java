package com.perday.expensemanager.repository;

import com.perday.expensemanager.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface ExpenseRepository extends MongoRepository<Expense, String> {
    List<Expense> findByExpensePaidDateTimeBetween(LocalDateTime startDate, LocalDateTime endDate);
    List<Expense> findByCategory(String category);
}
