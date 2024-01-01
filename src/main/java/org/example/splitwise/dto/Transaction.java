package org.example.splitwise.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.splitwise.model.User;

@Getter
@Setter
public class Transaction {
    //A->B = res 100;

    private User payer;
    private User receiver;
    private int amount;
}