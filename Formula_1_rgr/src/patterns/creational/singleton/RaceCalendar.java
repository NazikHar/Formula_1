package patterns.creational.singleton;

import java.util.Arrays;
import java.util.List;

public class RaceCalendar {
    //  Створення єдиного екземпляру
    private static final RaceCalendar INSTANCE = new RaceCalendar();
    private List<String> races;

    //  Приватний конструктор, щоб заборонити створення екземплярів ззовні
    private RaceCalendar() {
        // Імітація завантаження календаря
        races = Arrays.asList("Bahrain GP", "Monaco GP", "Italian GP");
        System.out.println("\nRace Calendar initialized.");
    }

    // метод для отримання доступу до єдиного екземпляру
    public static RaceCalendar getInstance() {
        return INSTANCE;
    }

    public void printCalendar() {
        System.out.println("F1 Race Calendar for the season:");
        races.forEach(System.out::println);
    }
}