package org.example.splitwise.service;

import org.example.splitwise.strategy.SettleUpStrategy;
import org.example.splitwise.dto.Transaction;
import org.example.splitwise.model.Expense;
import org.example.splitwise.model.ExpenseUser;
import org.example.splitwise.model.Group;
import org.example.splitwise.model.User;
import org.example.splitwise.repository.ExpenseRepository;
import org.example.splitwise.repository.ExpenseUserRepository;
import org.example.splitwise.repository.GroupRepository;
import org.example.splitwise.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SettleUpService {
    private UserRepository userRepository;
    private ExpenseRepository expenseRepository;
    private ExpenseUserRepository expenseUserRepository;
    private SettleUpStrategy settleUpStrategy;
    private GroupRepository groupRepository;

    public SettleUpService(UserRepository userRepository, ExpenseRepository expenseRepository) {
        this.userRepository = userRepository;
        this.expenseRepository = expenseRepository;
    }

    public List<Transaction> settleUpUser(Long userId){
        /*
        1. Get all the expense in which user is part of
        2. Iterate through all the expenses and find out all the ppl involved in those expenses who owes how much extra/less
        3. use our algorithm (min and max heap) to find all the transactions
        4. return the transactions of the user
         */
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new RuntimeException("No user found");
        }
        User user = userOptional.get();
       List<ExpenseUser> expenseUser =  expenseUserRepository.findAllByUser(user);
       List<Expense> expenses = expenseUser.stream()
               .map(ExpenseUser::getExpense)
               .collect(Collectors.toList());
        List<Transaction> transactions = settleUpStrategy.settleUp(expenses);
        return transactions;
    }
    public List<Transaction> settleUpGroup(Long groupId) {
        /*
        1. Get all the expense that were made in the group.
        2. Iterate through all the expenses and find out all the ppl involved in those expenses who owes how much extra/less
        3. use our algorithm (min and max heap) to find all the transactions
        4. return the transactions of the user
         */
        Optional<Group> groupOptional = groupRepository.findById(groupId);
        if(groupOptional.isEmpty()){
            throw new RuntimeException("No group found");
        }
        Group group = groupOptional.get();
        List<Expense> expenses = group.getExpenses();
        List<Transaction> transactions = settleUpStrategy.settleUp(expenses);
        return transactions;
    }
}