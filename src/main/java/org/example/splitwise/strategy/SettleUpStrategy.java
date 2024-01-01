package org.example.splitwise.strategy;

import org.example.splitwise.dto.Transaction;
import org.example.splitwise.model.Expense;

import java.util.List;

public interface SettleUpStrategy {
    public List<Transaction> settleUp(List<Expense> expensesToSettleUp);
}