package domain.members;

// Клас який дає працювати далі з всіма учасниками команди як з єдиною командою

public abstract class TeamMember {
    private String name;
    private int experience; // years

    public TeamMember(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    // Доступ до полів через публічні методи

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }


    // Цей метод перевизначений в класах нащадках
    public abstract void performTask();

    @Override
    public String toString() {
        return String.format("Name: %s, Experience: %d years", name, experience);
    }
}