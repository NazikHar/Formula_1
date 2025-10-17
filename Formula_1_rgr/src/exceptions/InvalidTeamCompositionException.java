package exceptions;

// виключення що сигналізує про порушення структури команди
public class InvalidTeamCompositionException extends Exception {
    public InvalidTeamCompositionException(String message) {
        super(message);
    }
}