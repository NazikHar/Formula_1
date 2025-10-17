package domain.members;

// Сутність пілота

public class Driver extends TeamMember {
    private int skillLevel; // 1-100

    public Driver(String name, int experience, int skillLevel) {
        super(name, experience);
        this.skillLevel = skillLevel;
    }

    public int getSkillLevel() {
        return skillLevel;
    }


    // Опис та виведення інформації про типове завдання пілота - тренуватись
    @Override
    public void performTask() {
        System.out.println("Driver " + getName() + " is practicing on the simulator.");
    }
}