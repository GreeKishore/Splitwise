package org.example.splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity(name = "user_groups")
public class Group extends BaseModel{
    private String name;
    @ManyToMany
    private List<User> members;
    @OneToMany(mappedBy = "group") //mappedby parameter is used because same relation is also explicitly specified in the Expenses class. Just to avoid duplicate column in the two tables we are just giving it
    private List<Expense> expenses;
    @ManyToOne
    private User createdBy;
}