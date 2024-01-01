package org.example.splitwise.repository;

import org.example.splitwise.model.Expense;
import org.example.splitwise.model.ExpenseUser;
import org.example.splitwise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseUserRepository extends JpaRepository<ExpenseUser,Long> {
    List<ExpenseUser> findAllByUser(User user);
}