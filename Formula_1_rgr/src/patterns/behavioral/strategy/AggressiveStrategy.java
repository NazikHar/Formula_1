package patterns.behavioral.strategy;

import domain.car.Car;


public class AggressiveStrategy implements RaceStrategy {
    @Override
    public void drive(Car car) {
        System.out.println(">>> STRATEGY: Aggressive Mode Activated!");
        System.out.println("   -> Pushing the engine to the limit...");

        System.out.println("   -> Lap times are FAST (-1.5 sec/lap)");
        System.out.println("   -> Engine wear increased by 10%");
    }
}