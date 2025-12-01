package domain.car;

import exceptions.ComponentFailureException;

//Клас де обєднуються компоненти машини і можна її порахувати

public class Car {
    private Engine engine;
    private Chassis chassis;

    public Car(Engine engine, Chassis chassis) {
        this.engine = engine;
        this.chassis = chassis;
    }

    public void performSystemsCheck() throws ComponentFailureException {
        System.out.println("Performing systems check for " + this);
        engine.checkStatus();   // Може викинути виключення
        chassis.checkStatus();  // Може викинути виключення
        System.out.println("Systems check passed. All Green.");
    }

    public double getOverallPerformance() {
        // Car сам розраховує свою продуктивність
        return engine.getPerformanceContribution() + chassis.getPerformanceContribution();
    }

    @Override
    public String toString() {
        return String.format("Car -> Overall Performance: %.2f", getOverallPerformance());
    }
}