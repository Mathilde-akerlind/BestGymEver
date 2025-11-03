package se.bestgymever;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class TrainingLogger {

    private String logFilePath;

    public TrainingLogger(String logFilePath) {
        this.logFilePath = logFilePath;
    }

    public void logTraining(Member member) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(logFilePath, true))) {
            String line = member.getName() + ";" +
                    member.getPersonalNumber() + ";" +
                    LocalDate.now();
            writer.println(line);
            System.out.println("Träningsbesök loggat för " + member.getName() + ".");
        } catch (IOException e) {
            System.err.println("Kunde inte skriva till träningsloggen: " + e.getMessage());
        }
    }
}
