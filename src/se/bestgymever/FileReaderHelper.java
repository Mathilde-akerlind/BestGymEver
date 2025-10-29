package se.bestgymever;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderHelper {

    public static List<Member> readMembersFromFile(String filePath) {
        List<Member> members = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Member m = Member.fromFileLine(line);
                if (m != null) {
                    members.add(m);
                }
            }
        } catch (IOException e) {
            System.err.println("Fel vid inläsning av fil: " + e.getMessage());
        }

        return members;
    }
}
