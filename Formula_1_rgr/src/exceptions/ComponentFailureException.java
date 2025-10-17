package exceptions;

// виключення про несправність боліду
public class ComponentFailureException extends Exception {
    public ComponentFailureException(String message) {
        super(message);
    }
}