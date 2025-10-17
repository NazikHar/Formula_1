package patterns.creational.factory_method;

import domain.members.Driver;
import domain.members.Engineer;
import domain.members.TeamMember;

// Інкапсулює логіку створення членів команди.

public class TeamMemberFactory {
    public TeamMember createTeamMember(String type, String name, int experience, Object... args) {
        if ("driver".equalsIgnoreCase(type)) {
            int skillLevel = (int) args[0];
            return new Driver(name, experience, skillLevel);
        } else if ("engineer".equalsIgnoreCase(type)) {
            String specialization = (String) args[0];
            return new Engineer(name, experience, specialization);
        }
        throw new IllegalArgumentException("Unknown member type: " + type);
    }
}