package exceptions;

// це виключення для бюджету
public class BudgetExceededException extends Exception {
    public BudgetExceededException(String message) {
        super(message);
    }
}