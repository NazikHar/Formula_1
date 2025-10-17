package main;

import domain.Team;
import domain.car.Car;
import domain.car.Chassis;
import domain.car.Engine;
import domain.members.Driver;
import domain.members.Engineer;
import exceptions.BudgetExceededException;

public class Main {
    public static void main(String[] args) {
        System.out.println("     FORMULA 1 TEAM     ");

        // Створюємо об'єкти напряму, без патернів
        Team myTeam = new Team("Red Bull", 100_000_000);
        Driver driver1 = new Driver("Nazar", 5, 97);
        Driver driver2 = new Driver("Ivan", 1, 80);
        Engineer engineer = new Engineer("Danya", 10, "Aerodynamics");

        // Створюємо компоненти боліда
        Engine engine = new Engine("HP-V8", 950);
        Chassis chassis = new Chassis("HPC-01", 4.5);
        Car car = new Car(engine, chassis);

        // Демонструємо, що об'єкти створено
        System.out.println("Team created: " + myTeam.getName());


        // Тепер ми обробляємо можливі помилки
        try {
            System.out.println("\nAttempting to hire drivers...");
            myTeam.hireDriver(driver1, 50_000_000);

            // Ця спроба має провалитися і викликати виключення
            System.out.println("Attempting to hire a second driver...");
            myTeam.hireDriver(driver2, 60_000_000);

            System.out.println("This line will not be reached.");

        } catch (BudgetExceededException e) {
            // "Ловимо" помилку і виводимо її повідомлення
            System.err.println("OPERATION FAILED: " + e.getMessage());
        }

        System.out.println("\nHired driver: " + driver1.getName());
        myTeam.setCar(car);
        System.out.println("Car performance: " + car.getOverallPerformance());

        // Демонструємо поліморфізм
        System.out.println("\n--- Team daily tasks ---");
        driver1.performTask();
        engineer.performTask();

    }
}