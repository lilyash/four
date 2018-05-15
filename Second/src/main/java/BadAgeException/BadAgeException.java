package BadAgeException;

public class BadAgeException extends Exception {
    public BadAgeException() {
    }

    public BadAgeException(String message) {
        super(message);
    }

    public BadAgeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadAgeException(Throwable cause) {
        super(cause);
    }
}
