package test;

import domain.Team;
import domain.members.Driver;
import exceptions.BudgetExceededException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    @Test
    void testHireDriverWithinBudget() {
        // 1. Створюємо команду з бюджетом 1000
        Team team = new Team("Test Team", 1000);
        Driver driver = new Driver("Test Driver", 5, 80);

        // 2. Наймаємо пілота за 500 (має пройти успішно)
        assertDoesNotThrow(() -> {
            team.hireDriver(driver, 500);
        });
    }

    @Test
    void testHireDriverExceedsBudget() {
        // 1. Створюємо команду з бюджетом 100
        Team team = new Team("Poor Team", 100);
        Driver driver = new Driver("Expensive Driver", 5, 99);

        // 2. Спробуємо найняти за 500 (має викинути помилку)
        Exception exception = assertThrows(BudgetExceededException.class, () -> {
            team.hireDriver(driver, 500);
        });

        // 3. Перевіряємо текст помилки
        assertTrue(exception.getMessage().contains("Not enough budget"));
    }
}