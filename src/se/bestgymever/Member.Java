package se.bestgymever;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Member {
    private String name;
    private String address;
    private String email;
    private String personalNumber;
    private LocalDate memberSince;
    private LocalDate lastPaymentDate;
    private String membershipType;

    public Member(String name, String address, String email, String personalNumber,
                  LocalDate memberSince, LocalDate lastPaymentDate, String membershipType) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.personalNumber = personalNumber;
        this.memberSince = memberSince;
        this.lastPaymentDate = lastPaymentDate;
        this.membershipType = membershipType;
    }

    public static Member fromFileLine(String line) {
        try {
            String[] parts = line.split(";");
            if (parts.length != 7) {
                System.err.println("Felaktig rad i filen: " + line);
                return null;
            }

            String name = parts[0].trim();
            String address = parts[1].trim();
            String email = parts[2].trim();
            String personalNumber = parts[3].trim();
            LocalDate memberSince = LocalDate.parse(parts[4].trim());
            LocalDate lastPaymentDate = LocalDate.parse(parts[5].trim());
            String membershipType = parts[6].trim();

            return new Member(name, address, email, personalNumber, memberSince, lastPaymentDate, membershipType);
        } catch (DateTimeParseException e) {
            System.err.println("Kunde inte tolka datum i raden: " + line);
            return null;
        } catch (Exception e) {
            System.err.println("Fel vid parsning av medlem: " + e.getMessage());
            return null;
        }
    }

    public boolean isActive() {
        return lastPaymentDate.isAfter(LocalDate.now().minusYears(1));
    }

    public String getName() {
        return name;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public LocalDate getLastPaymentDate() {
        return lastPaymentDate;
    }

    @Override
    public String toString() {
        return name + " (" + personalNumber + ") - " + membershipType +
                "\nSenast betalat: " + lastPaymentDate +
                "\nAdress: " + address +
                "\nE-post: " + email;
    }
}
