package se.bestgymever;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "members.txt";

        List<Member> members = FileReaderHelper.readMembersFromFile(filePath);

        System.out.println("Antal medlemmar inlästa: " + members.size());
        for (Member m : members) {
            System.out.println("------------------------");
            System.out.println(m);
        }
    }
}
