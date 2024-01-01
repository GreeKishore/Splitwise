package org.example.splitwise.commandexecutor;

public interface Command {
    boolean matches(String input);
    void execute(String input);
}