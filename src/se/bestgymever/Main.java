package se.bestgymever;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = "members.txt"; // filen i projektets rotmapp
        List<Member> members = FileReaderHelper.readMembersFromFile(filePath);

        if (members.isEmpty()) {
            System.out.println("Inga medlemmar kunde läsas in. Kontrollera filen.");
            return;
        }

        MemberFinder finder = new MemberFinder(members);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Välkommen till Best Gym Ever!");
        System.out.println("Skriv ett namn eller personnummer för att söka (eller 'exit' för att avsluta).");

        while (true) {
            System.out.print("Sök: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Programmet avslutas.");
                break;
            }

            finder.printMemberCategory(input);
            System.out.println();
        }
    }
}
