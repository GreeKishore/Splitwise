package org.example.splitwise.commandexecutor;

import org.example.splitwise.controller.SettleUpController;
import org.example.splitwise.dto.SettleUpUserRequestDto;
import org.example.splitwise.dto.SettleUpUserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSettleUpCommand implements Command{
    private SettleUpController settleUpController;
    @Autowired
    public UserSettleUpCommand(SettleUpController settleUpController) {
        this.settleUpController = settleUpController;
    }

    @Override
    public boolean matches(String input) {
        String[] words = input.split(" ");
        return words.length == 2 && words[1].equalsIgnoreCase("SettleUp");
    }

    @Override
    public void execute(String input) {
        String[] words = input.split(" ");
        Long userId = Long.valueOf(words[0]);
        SettleUpUserRequestDto settleUpUserRequestDto = new SettleUpUserRequestDto();
        settleUpUserRequestDto.setUserId(userId);
        SettleUpUserResponseDto response = settleUpController.settleUpUser(settleUpUserRequestDto);
        System.out.println(response.getResponseStatus());
    }
}