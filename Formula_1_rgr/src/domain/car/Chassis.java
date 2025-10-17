package domain.car;

// окремий компонент машини

public class Chassis extends domain.car.CarComponent {
    private double downforceLevel; // in G

    public Chassis(String id, double downforceLevel) {
        super(id); // зв'язок з батьківським класом CarComponent
        this.downforceLevel = downforceLevel;
    }

    @Override
    public double getPerformanceContribution() {
        return downforceLevel * 150 * (condition / 100.0); // розрахунок зносу шасі
    }
}