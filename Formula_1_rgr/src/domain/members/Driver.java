package domain.members;
import domain.car.Car;
import patterns.behavioral.strategy.RaceStrategy;

// Сутність пілота

public class Driver extends TeamMember {
    private int skillLevel; // 1-100
    private RaceStrategy strategy;

    public Driver(String name, int experience, int skillLevel) {
        super(name, experience);
        this.skillLevel = skillLevel;
    }

    public void setStrategy(RaceStrategy strategy) {
        this.strategy = strategy;
    }

    // <--- НОВИЙ МЕТОД: Щоб пілот міг застосувати стратегію до машини
    public void driveRace(Car car) {
        if (strategy == null) {
            System.out.println(getName() + " has no strategy assigned! Driving normally.");
        } else {
            System.out.print(getName() + " is applying strategy: ");
            strategy.drive(car);
        }
    }

    public int getSkillLevel() {
        return skillLevel;
    }


    // Опис та виведення інформації про типове завдання пілота - тренуватись
    @Override
    public void performTask() {
        System.out.println("Driver " + getName() + " is practicing on the simulator.");
    }
}