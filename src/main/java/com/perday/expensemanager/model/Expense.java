package com.perday.expensemanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "expenses")
@Schema(description = "Expense Entity")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the expense", example = "1")
    private Long id;
    
    @Schema(description = "Description of the expense", example = "Grocery shopping")
    private String description;

    @Schema(description = "Amount spent", example = "50.00")
    private BigDecimal amount;

    @Schema(description = "Category of the expense", example = "Food")
    private String category;

    @Schema(description = "Date and time of the expense", example = "2025-10-05T10:30:00")
    private LocalDateTime expensePaidDateTime;

    @Schema(description = "Payment method used", example = "Credit Card")
    private String paymentMethod;

    @Schema(description = "Additional notes about the expense", example = "Monthly groceries")
    private String notes;

    @Schema(description = "Start date and time of the expense period", example = "2025-10-06T00:00:00")
    private LocalDateTime expensePeriodStart = LocalDateTime.now();

    @Schema(description = "End date and time of the expense period", example = "2045-10-06T00:00:00")
    private LocalDateTime expensePeriodEnd = LocalDateTime.now().plusYears(20);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getExpensePaidDateTime() {
        return expensePaidDateTime;
    }

    public void setExpensePaidDateTime(LocalDateTime date) {
        this.expensePaidDateTime = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getExpensePeriodStart() {
        return expensePeriodStart;
    }

    public void setExpensePeriodStart(LocalDateTime expensePeriodStart) {
        this.expensePeriodStart = expensePeriodStart;
    }

    public LocalDateTime getExpensePeriodEnd() {
        return expensePeriodEnd;
    }

    public void setExpensePeriodEnd(LocalDateTime expensePeriodEnd) {
        this.expensePeriodEnd = expensePeriodEnd;
    }
}
