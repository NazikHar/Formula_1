package main;

import domain.Team;
import domain.car.Car;
import domain.members.Driver;
import domain.members.TeamMember;
import exceptions.BudgetExceededException;
import exceptions.InvalidTeamCompositionException;
import patterns.controller.RaceSimulator;
import patterns.creational.abstract_factory.CarPartFactory;
import patterns.creational.abstract_factory.HighPerformancePartFactory;
import patterns.creational.factory_method.TeamMemberFactory;
import patterns.creational.singleton.RaceCalendar;

public class Main {
    public static void main(String[] args) {
        System.out.println("     FORMULA 1 TEAM     ");

        // Використовуємо патерни для створення об'єктів
        TeamMemberFactory memberFactory = new TeamMemberFactory();
        Driver driver1 = new Driver("Nazar", 5, 97);
        Driver driver2 = new Driver("Ivan", 1, 80);
        Driver driver3 = new Driver("Sasha", 2, 85);


        CarPartFactory carFactory = new HighPerformancePartFactory();
        Car car = new Car(carFactory.createEngine(), carFactory.createChassis());

        Team myTeam = new Team("Red Bull", 100_000_000);
        myTeam.setCar(car);
        System.out.println("The team has chosen the car configuration: High Performance.");
        System.out.println(car + "\n");

        // Тут спрацює виключення на бюджет
        /**try {
            myTeam.hireDriver((Driver) driver1, 50_000_000);
            myTeam.hireDriver((Driver) driver2, 60_000_000);
        } catch (BudgetExceededException e) {
            System.err.println("Setup Error: " + e.getMessage());
            return;
        }**/

        try {
            myTeam.hireDriver((Driver) driver1, 50_000_000);
            myTeam.hireDriver((Driver) driver3, 30_000_000);
        } catch (BudgetExceededException e) {
            System.err.println("Setup Error: " + e.getMessage());
            return;
        }

        RaceCalendar.getInstance().printCalendar();

        // Створюємо контролер і передаємо йому керування
        RaceSimulator simulator = new RaceSimulator();
        try {
            simulator.startRace(myTeam);
        } catch (InvalidTeamCompositionException e) {
            System.err.println("Simulation Error: " + e.getMessage());
        }

        System.out.println("\nApplication finished.");
    }
}