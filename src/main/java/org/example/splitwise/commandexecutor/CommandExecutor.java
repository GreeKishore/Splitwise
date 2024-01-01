package org.example.splitwise.commandexecutor;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandExecutor {
    private List<Command> commands = new ArrayList<>();

    public CommandExecutor(UserSettleUpCommand userSettleUpCommand) {
        commands.add(userSettleUpCommand);
    }

    public void add(Command command){
        commands.add(command);
    }

    public void remove(Command command){
        commands.remove(command);
    }

    public void execute(String input) {
        commands.stream()
                .filter(command -> command.matches(input))
                .findFirst()
                .ifPresent(command -> command.execute(input));
    }
}