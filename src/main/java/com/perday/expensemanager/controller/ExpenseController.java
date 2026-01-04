package com.perday.expensemanager.controller;

import com.perday.expensemanager.model.Expense;
import com.perday.expensemanager.service.ExpenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@Tag(name = "Expense Management", description = "Expense management APIs")
public class ExpenseController {
    
    @Autowired
    private ExpenseService expenseService;
    
    @Operation(summary = "Get all expenses", description = "Retrieves a list of all expenses")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved all expenses", 
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = Expense.class)))
    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }
    
    @Operation(summary = "Get an expense by ID", description = "Retrieves an expense by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved the expense",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Expense.class))),
        @ApiResponse(responseCode = "404", description = "Expense not found", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@Parameter(description = "ID of the expense to retrieve") @PathVariable Long id) {
        Expense expense = expenseService.getExpenseById(id);
        return ResponseEntity.ok(expense);
    }
    
    @Operation(summary = "Create a new expense", description = "Creates a new expense entry")
    @ApiResponse(responseCode = "200", description = "Successfully created the expense",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = Expense.class)))
    @PostMapping
    public ResponseEntity<Expense> createExpense(@Parameter(description = "Expense to create") @RequestBody Expense expense) {
        Expense newExpense = expenseService.createExpense(expense);
        return ResponseEntity.ok(newExpense);
    }
    
    @Operation(summary = "Update an expense", description = "Updates an existing expense by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully updated the expense",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Expense.class))),
        @ApiResponse(responseCode = "404", description = "Expense not found", content = @Content)
    })
    @PatchMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(
            @Parameter(description = "ID of the expense to update") @PathVariable Long id,
            @Parameter(description = "Updated expense details") @RequestBody Expense expenseDetails) {
        Expense updatedExpense = expenseService.updateExpense(id, expenseDetails);
        return ResponseEntity.ok(updatedExpense);
    }

    //add PUT implementation
    @Operation(summary = "Replace an expense", description = "Replaces an existing expense by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully replaced the expense",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Expense.class))),
        @ApiResponse(responseCode = "404", description = "Expense not found", content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<Expense> replaceExpense(
            @Parameter(description = "ID of the expense to replace") @PathVariable Long id,
            @Parameter(description = "New expense details") @RequestBody Expense expenseDetails) {
        Expense replacedExpense = expenseService.replaceExpense(id, expenseDetails);
        return ResponseEntity.ok(replacedExpense);
    }
    
    @Operation(summary = "Delete an expense", description = "Deletes an expense by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully deleted the expense"),
        @ApiResponse(responseCode = "404", description = "Expense not found", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExpense(@Parameter(description = "ID of the expense to delete") @PathVariable Long id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.ok().build();
    }
    
    @Operation(summary = "Get expenses by date range", description = "Retrieves expenses within a specified date range")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved expenses for the date range",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = Expense.class)))
    @GetMapping("/byDateRange")
    public List<Expense> getExpensesByDateRange(
            @Parameter(description = "Start date (ISO format)") 
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @Parameter(description = "End date (ISO format)") 
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return expenseService.getExpensesByDateRange(startDate, endDate);
    }
    
    @Operation(summary = "Get expenses by category", description = "Retrieves expenses by their category")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved expenses for the category",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = Expense.class)))
    @GetMapping("/byCategory/{category}")
    public List<Expense> getExpensesByCategory(
            @Parameter(description = "Category to filter by") @PathVariable String category) {
        return expenseService.getExpensesByCategory(category);
    }
}
