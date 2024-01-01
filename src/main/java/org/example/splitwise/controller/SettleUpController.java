package org.example.splitwise.controller;

import org.example.splitwise.dto.*;
import org.example.splitwise.model.ResponseStatus;
import org.example.splitwise.service.SettleUpService;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class SettleUpController {
    private SettleUpService settleUpService;
    public SettleUpUserResponseDto settleUpUser(SettleUpUserRequestDto settleUpUserRequestDto){
        SettleUpUserResponseDto settleUpUserResponseDto = new SettleUpUserResponseDto();
        try {
            List<Transaction> transactions = settleUpService.settleUpUser(settleUpUserRequestDto.getUserId());
            settleUpUserResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            settleUpUserResponseDto.setTransactions(transactions);
        }catch (Exception e)
        {
            settleUpUserResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return settleUpUserResponseDto;
    }

    public SettleUpGroupResponseDto settleUpGroup(SettleUpGroupRequestDto settleUpGroupRequestDto){
        SettleUpGroupResponseDto settleUpGroupResponseDto = new SettleUpGroupResponseDto();
        try {
            List<Transaction> transactions = settleUpService.settleUpGroup(settleUpGroupRequestDto.getGroupId());
            settleUpGroupResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            settleUpGroupResponseDto.setTransactions(transactions);
        }catch (Exception e)
        {
            settleUpGroupResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return settleUpGroupResponseDto;
    }
}