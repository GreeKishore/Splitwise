package org.example.splitwise.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "users") //Always name the table in plural form.
public class User extends BaseModel{
    private String name;
    private String phoneNumber;
    private String password;
}