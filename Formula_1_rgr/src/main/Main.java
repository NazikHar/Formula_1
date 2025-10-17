package main;

import domain.Team;
import domain.car.Car;
import domain.car.Chassis;
import domain.car.Engine;
import domain.members.Driver;
import domain.members.Engineer;

public class Main {
    public static void main(String[] args) {
        System.out.println("     FORMULA 1 TEAM     ");

        // Створюємо об'єкти напряму, без патернів
        Team myTeam = new Team("Red Bull", 100_000_000);
        Driver driver = new Driver("Nazar", 5, 97);
        Engineer engineer = new Engineer("Danya", 10, "Aerodynamics");

        // Створюємо компоненти боліда
        Engine engine = new Engine("HP-V8", 950);
        Chassis chassis = new Chassis("HPC-01", 4.5);
        Car car = new Car(engine, chassis);

        // Демонструємо, що об'єкти створено
        System.out.println("Team created: " + myTeam.getName());
        System.out.println("Hired driver: " + driver.getName());
        myTeam.setCar(car);
        System.out.println("Car performance: " + car.getOverallPerformance());

        // Демонструємо поліморфізм
        System.out.println("\n--- Team daily tasks ---");
        driver.performTask();
        engineer.performTask();
    }
}