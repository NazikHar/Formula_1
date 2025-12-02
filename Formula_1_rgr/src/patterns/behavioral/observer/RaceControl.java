package patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class RaceControl {
    private List<RaceObserver> observers = new ArrayList<>();

    public void addObserver(RaceObserver observer) {
        observers.add(observer);
    }

    public void broadcastMessage(String message) {
        System.out.println("\n[RACE CONTROL] BROADCAST: " + message);
        for (RaceObserver observer : observers) {
            observer.update(message);
        }
    }
}