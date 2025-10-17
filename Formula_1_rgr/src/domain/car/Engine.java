package domain.car;

// окремий компонент машини

public class Engine extends domain.car.CarComponent {
    private int horsePower;

    public Engine(String id, int horsePower) {
        super(id); // зв'язок з батьківським класом
        this.horsePower = horsePower;
    }

    @Override
    public double getPerformanceContribution() {
        return horsePower * (condition / 100.0); // Розрахунок потужності двигуна
    }
}