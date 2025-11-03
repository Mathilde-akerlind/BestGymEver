package se.bestgymever;

import java.util.List;

public class MemberFinder {

    private List<Member> members;

    public MemberFinder(List<Member> members) {
        this.members = members;
    }

    public Member findMember(String query) {
        for (Member m : members) {
            if (m.getPersonalNumber().equalsIgnoreCase(query)
                    || m.getName().equalsIgnoreCase(query)) {
                return m;
            }
        }
        return null;
    }

    public void printMemberCategory(String query) {
        Member m = findMember(query);

        if (m == null) {
            System.out.println("Personen finns inte i systemet (obehörig).");
            return;
        }

        if (m.isActive()) {
            System.out.println(m.getName() + " är en nuvarande medlem (" + m.getMembershipType() + ").");
        } else {
            System.out.println(m.getName() + " är en före detta kund.");
        }
    }
}
