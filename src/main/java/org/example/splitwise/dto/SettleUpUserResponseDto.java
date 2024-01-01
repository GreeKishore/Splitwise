package org.example.splitwise.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.splitwise.model.ResponseStatus;

import java.util.List;

@Getter
@Setter
public class SettleUpUserResponseDto {
    private ResponseStatus responseStatus;
    List<Transaction> transactions;
}