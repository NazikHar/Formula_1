package patterns.structural.decorator;

import domain.car.Chassis;

public class AerodynamicUpgrade extends ChassisDecorator {
    public AerodynamicUpgrade(Chassis chassis) {
        super(chassis);
    }

    @Override
    public double getPerformanceContribution() {
        // Додаємо 20% до ефективності
        return super.getPerformanceContribution() + 20.0;
    }
}