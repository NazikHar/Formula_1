package domain.car;

// Клас який дає працювати далі з всіма компонентами як одним ціоим
// (Компоненти юудуть ще додаватись)

public abstract class CarComponent {
    private String id;
    protected double condition = 100.0; // Стан компоненту

    public CarComponent(String id) {
        this.id = id;
    }

    public double getCondition() {
        return condition;
    }

    public abstract double getPerformanceContribution();
}