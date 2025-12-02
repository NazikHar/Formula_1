package patterns.structural.decorator;

import domain.car.Chassis;

public abstract class ChassisDecorator extends Chassis {
    protected Chassis decoratedChassis;

    public ChassisDecorator(Chassis chassis) {
        super("DECORATED", 0);
        this.decoratedChassis = chassis;
    }

    @Override
    public double getPerformanceContribution() {
        return decoratedChassis.getPerformanceContribution();
    }

    @Override
    public void checkStatus() throws exceptions.ComponentFailureException {
        decoratedChassis.checkStatus();
    }
}