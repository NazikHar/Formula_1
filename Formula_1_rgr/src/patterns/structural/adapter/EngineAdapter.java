package patterns.structural.adapter;

import domain.car.Engine;

public class EngineAdapter extends Engine {
    private TurboEngine3000 turboEngine;

    public EngineAdapter(TurboEngine3000 turboEngine) {
        super("ADAPTED-TURBO", 0); // Параметри не важливі, бо ми їх перекриваємо
        this.turboEngine = turboEngine;
    }

    @Override
    public double getPerformanceContribution() {
        // Адаптуємо чужий метод getThrust() до нашого інтерфейсу
        return turboEngine.getThrust();
    }

    @Override
    public void checkStatus() {
        // Сторонній двигун завжди справний для спрощення
    }
}