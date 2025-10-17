package patterns.creational.abstract_factory;

import domain.car.Chassis;
import domain.car.Engine;

// Абстрактна фабрика для створення сімейства компонентів боліда

public interface CarPartFactory {
    Engine createEngine();
    Chassis createChassis();
}