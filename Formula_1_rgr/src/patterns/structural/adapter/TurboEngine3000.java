package patterns.structural.adapter;

public class TurboEngine3000 {
    public void startTurbo() {
        System.out.println("TurboEngine3000 started! Vroom-vroom!");
    }

    // У цього класу немає getPerformanceContribution(), але є це:
    public float getThrust() {
        return 1500.0f;
    }
}