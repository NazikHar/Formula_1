package patterns.creational.abstract_factory;

import domain.car.Chassis;
import domain.car.Engine;

// Ця фабрика створє надійні елементи

public class ReliablePartFactory implements CarPartFactory {
    @Override
    public Engine createEngine() {
        return new Engine("REL-V6", 880);
    }

    @Override
    public Chassis createChassis() {
        return new Chassis("RLC-01", 4.1);
    }
}