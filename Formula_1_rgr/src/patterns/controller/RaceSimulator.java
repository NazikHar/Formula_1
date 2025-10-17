package patterns.controller;

import domain.Team;
import exceptions.InvalidTeamCompositionException;

// Приймає запити від мейн і координує роботу об'єктів моделі

public class RaceSimulator {
    public void startRace(Team team) throws InvalidTeamCompositionException {
        System.out.println("\n--- RACE START ---");
        // приклад використання виключення
        if (team == null) {
            throw new InvalidTeamCompositionException("No team provided for the race.");
        }
        team.prepareForRace();
        System.out.println("Simulating race for team " + team.getName());
        System.out.println(team.getName() + " win the GP");
        System.out.println("--- RACE FINISHED ---\n");
    }
}