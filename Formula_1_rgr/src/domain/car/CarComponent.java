package domain.car;

import exceptions.ComponentFailureException;

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

    public void checkStatus() throws exceptions.ComponentFailureException {
        if (getCondition() < 20.0) {
            throw new exceptions.ComponentFailureException("Component " + id + " FAILED! Condition is critical: " + getCondition() + "%");
        }
    }

    public void setCondition(double condition) {
        if (condition < 0) condition = 0;
        if (condition > 100) condition = 100;
        this.condition = condition;
    }

    public abstract double getPerformanceContribution();
}