package com.perday.expensemanager.service;

import com.perday.expensemanager.model.Expense;
import com.perday.expensemanager.repository.ExpenseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExpenseService {
    
    @Autowired
    private ExpenseRepository expenseRepository;
    
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }
    
    public Expense getExpenseById(String id) {
        return expenseRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));
    }
    
    public Expense createExpense(Expense expense) {
        if (expense.getExpensePaidDateTime() == null) {
            expense.setExpensePaidDateTime(LocalDateTime.now());
        }
        return expenseRepository.save(expense);
    }
    
    public Expense updateExpense(String id, Expense expenseDetails) {
        Expense expense = getExpenseById(id);
        expense.setDescription(expenseDetails.getDescription());
        expense.setAmount(expenseDetails.getAmount());
        expense.setCategory(expenseDetails.getCategory());
        expense.setPaymentMethod(expenseDetails.getPaymentMethod());
        expense.setNotes(expenseDetails.getNotes());
        return expenseRepository.save(expense);
    }

    // method for replacing an expense
    public Expense replaceExpense(String id, Expense expenseDetails) {
        Expense expense = getExpenseById(id);
        // ensure a paid date is present
        if (expenseDetails.getExpensePaidDateTime() == null) {
            expenseDetails.setExpensePaidDateTime(LocalDateTime.now());
        }
        // copy properties from incoming details into the managed entity, but keep the id
        BeanUtils.copyProperties(expenseDetails, expense, "id");
        return expenseRepository.save(expense);
    }

    public void deleteExpense(String id) {
        Expense expense = getExpenseById(id);
        expenseRepository.delete(expense);
    }
    
    public List<Expense> getExpensesByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return expenseRepository.findByExpensePaidDateTimeBetween(startDate, endDate);
    }
    
    public List<Expense> getExpensesByCategory(String category) {
        return expenseRepository.findByCategory(category);
    }
}
