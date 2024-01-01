package org.example.splitwise.strategy;

import org.example.splitwise.dto.Transaction;
import org.example.splitwise.model.Expense;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class HeapSettleUpStrategy implements SettleUpStrategy{
    @Override
    public List<Transaction> settleUp(List<Expense> expensesToSettleUp) {
        return null;
    }
}