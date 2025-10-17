package domain.members;

// Сутність інженера

public class Engineer extends TeamMember {
    private String specialization;

    public Engineer(String name, int experience, String specialization) {
        super(name, experience);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }


    // Виведення загальної інформації про інженера
    @Override
    public void performTask() {
        System.out.println("Engineer " + getName() + " is analyzing telemetry data.");
    }
}