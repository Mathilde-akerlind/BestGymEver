package se.bestgymever;

import java.util.List;

public class MemberFinder {

    private List<Member> members;
    private TrainingLogger logger;

    public MemberFinder(List<Member> members, TrainingLogger logger) {
        this.members = members;
        this.logger = logger;
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
            logger.logTraining(m);
        } else {
            System.out.println(m.getName() + " är en före detta kund.");
        }
    }
}
