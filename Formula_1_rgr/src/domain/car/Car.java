package domain.car;

//Клас де обєднуються компоненти машини і можна її порахувати

public class Car {
    private Engine engine;
    private Chassis chassis;

    public Car(Engine engine, Chassis chassis) {
        this.engine = engine;
        this.chassis = chassis;
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