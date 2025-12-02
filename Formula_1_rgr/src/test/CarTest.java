package test;

import domain.car.Car;
import domain.car.Chassis;
import domain.car.Engine;
import exceptions.ComponentFailureException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void testCarFailsSystemCheck() {
        // 1. Створюємо компоненти
        Engine engine = new Engine("TestV8", 1000);
        Chassis chassis = new Chassis("TestChassis", 1.0);

        // 2. Ламаємо двигун (стан 10%)
        engine.setCondition(10.0);

        Car car = new Car(engine, chassis);

        // 3. Перевіряємо, що checkStatus() викидає помилку
        assertThrows(ComponentFailureException.class, () -> {
            car.performSystemsCheck();
        });
    }
}