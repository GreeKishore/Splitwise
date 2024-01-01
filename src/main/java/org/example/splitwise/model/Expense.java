package org.example.splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="Expenses")
public class Expense extends BaseModel{
    private String description;
    private int amount;
    @ManyToOne
    private  Group group;
    @ManyToOne
    private User createdBy;
    @Enumerated (EnumType.ORDINAL)//Since expensetype is an enum we are using @Enumerated annotation and type  = ordinal means 0, 1 ,2 in this fashion enum is added.
    private ExpenseType expenseType;
}