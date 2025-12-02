package main;

import domain.Team;
import domain.car.Car;
import domain.members.Driver;
import domain.members.Engineer;
import exceptions.BudgetExceededException;
import exceptions.InvalidTeamCompositionException;
import patterns.controller.RaceSimulator;
import patterns.creational.abstract_factory.CarPartFactory;
import patterns.creational.abstract_factory.HighPerformancePartFactory;
import patterns.creational.factory_method.TeamMemberFactory;
import patterns.creational.singleton.RaceCalendar;
import patterns.structural.adapter.EngineAdapter;
import patterns.structural.adapter.TurboEngine3000;
import patterns.structural.decorator.AerodynamicUpgrade;
import patterns.behavioral.observer.RaceControl;

public class Main {
    public static void main(String[] args) {
        System.out.println("     FORMULA 1 TEAM     ");

        // Використовуємо патерни для створення об'єктів
        TeamMemberFactory memberFactory = new TeamMemberFactory();
        Driver driver1 = (Driver) memberFactory.createTeamMember("driver", "Nazar", 5, 97);
        // Driver driver2 = (Driver) memberFactory.createTeamMember("driver", "Ivan", 1, 80);
        Driver driver3 = (Driver) memberFactory.createTeamMember("driver", "Sasha", 2, 85);

        Engineer chiefEngineer = (Engineer) memberFactory.createTeamMember("engineer", "Danya", 30, "Aerodynamics");

        CarPartFactory carFactory = new HighPerformancePartFactory();

        // [ПАТЕРН ADAPTER]
        // Замість звичайного двигуна адаптуємо сторонній "TurboEngine3000"
        System.out.println("\n--- Installing Adapter ---");
        TurboEngine3000 alienEngine = new TurboEngine3000();
        domain.car.Engine myEngine = new EngineAdapter(alienEngine);

        // [ПАТЕРН DECORATOR]
        // Створюємо звичайне шасі, а потім "огортаємо" його в покращення
        System.out.println("--- Applying Decorator ---");
        domain.car.Chassis baseChassis = carFactory.createChassis();
        domain.car.Chassis myChassis = new AerodynamicUpgrade(baseChassis);

        System.out.println("\n!!! SABOTAGE: Damaging the engine before the race !!!");
        myEngine.setCondition(65.0);
        //myEngine.setCondition(15.0);

        // 3. Збираємо машину вже з пошкодженим двигуном
        Car car = new Car(myEngine, myChassis);

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

            myTeam.hireEngineer(chiefEngineer, 10_000_000);
        } catch (BudgetExceededException e) {
            System.err.println("Setup Error: " + e.getMessage());
            return;
        }

        System.out.println("\n--- TESTING STRATEGY PATTERN ---");

        driver1.setStrategy(new patterns.behavioral.strategy.AggressiveStrategy());
        driver1.driveRace(myTeam.getCar());

        // 2. Міняємо на спокійну стратегію (прямо під час виконання програми!)
        System.out.println("\n...Changing strategy due to rain...");
        driver1.setStrategy(new patterns.behavioral.strategy.ConservativeStrategy());
        driver1.driveRace(myTeam.getCar());

        // [ПАТЕРН OBSERVER]
        System.out.println("\n--- TESTING OBSERVER PATTERN ---");
        RaceControl raceControl = new RaceControl();
        raceControl.addObserver(myTeam); // Підписуємо команду на новини
        raceControl.broadcastMessage("Attention teams: Yellow flag in Sector 2!");

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