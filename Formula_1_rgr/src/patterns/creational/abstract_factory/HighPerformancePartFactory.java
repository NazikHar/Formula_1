package patterns.creational.abstract_factory;

import domain.car.Chassis;
import domain.car.Engine;

//Ця фабрика створює максимально продуктивні компоненти

public class HighPerformancePartFactory implements CarPartFactory {
    @Override
    public Engine createEngine() {
        return new Engine("HP-V8", 950);
    }

    @Override
    public Chassis createChassis() {
        return new Chassis("HPC-01", 4.5);
    }
}