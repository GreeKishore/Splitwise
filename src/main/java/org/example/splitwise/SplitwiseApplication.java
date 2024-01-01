package org.example.splitwise;

import org.example.splitwise.commandexecutor.CommandExecutor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Scanner;

@EnableJpaAuditing //This annotation says hibernate to check if we have values to create tables - Triggers the event
@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {
	private Scanner scanner = new Scanner(System.in);
	private CommandExecutor commandExecutor;

    public SplitwiseApplication(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		while(true) {
			String input = scanner.nextLine();
			commandExecutor.execute(input);
		}
	}
}