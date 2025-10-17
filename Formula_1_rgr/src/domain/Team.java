package domain;

import domain.car.Car;
import domain.members.Driver;
import domain.members.Engineer;
import java.util.ArrayList;
import java.util.List;

// клас об'єднує та керує всі іншимі сутності: пілоти, інженери та болід

// GRASP: Creator. Клас Team створює об'єкти Car та Driver, оскільки він їх агрегує.

public class Team {
    private String name;
    private double budget;
    private List<Driver> drivers = new ArrayList<>();
    private List<Engineer> engineers = new ArrayList<>();
    private Car car;

    public Team(String name, double budget) {
        this.name = name;
        this.budget = budget;
    }

    public void hireDriver(Driver driver, double salary) {
        this.budget -= salary;
        this.drivers.add(driver);
        System.out.printf("Hired driver %s. Remaining budget: %.2f\n", driver.getName(), budget);
    }

    public void setCar(Car car) {
        this.car = car;
        System.out.println("Team " + name + " has a new car.");
    }

    public void prepareForRace() {
        System.out.println("Team " + name + " is preparing for the race weekend.");
        for (Driver driver : drivers) {
            driver.performTask(); // Поліморфний виклик
        }
        for (Engineer engineer : engineers) {
            engineer.performTask(); // Поліморфний виклик
        }
    }

    public String getName() {
        return name;
    }
}