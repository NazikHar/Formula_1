package domain.car;

import exceptions.ComponentFailureException;

// Клас який дає працювати далі з всіма компонентами як одним цілим

public abstract class CarComponent {
    // [РЕФАКТОРИНГ] 1. Створюємо іменовану константу замість "магічного числа" 20.0
    private static final double CRITICAL_THRESHOLD = 20.0;

    private String id;
    protected double condition = 100.0; // Стан компоненту

    public CarComponent(String id) {
        this.id = id;
    }

    public double getCondition() {
        return condition;
    }

    public void checkStatus() throws ComponentFailureException {
        // [РЕФАКТОРИНГ] 2. Використовуємо зрозумілу назву замість просто числа
        if (getCondition() < CRITICAL_THRESHOLD) {
            throw new ComponentFailureException("Component " + id + " FAILED! Condition is critical: " + getCondition() + "%");
        }
    }

    public void setCondition(double condition) {
        if (condition < 0) condition = 0;
        if (condition > 100) condition = 100;
        this.condition = condition;
    }

    public abstract double getPerformanceContribution();
}