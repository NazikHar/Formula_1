package patterns.behavioral.strategy;

import domain.car.Car;

public class ConservativeStrategy implements RaceStrategy {
    @Override
    public void drive(Car car) {
        System.out.println(">>> STRATEGY: Conservative Mode Activated.");
        System.out.println("   -> Saving tires and fuel...");
        System.out.println("   -> Lap times are SLOW (+0.8 sec/lap)");
        System.out.println("   -> Engine wear is minimal (1%).");
    }
}