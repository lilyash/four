package Humans;

public class BadYearException extends Exception {
    public BadYearException() {
    }

    public BadYearException(String message) {
        super(message);
    }

    public BadYearException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadYearException(Throwable cause) {
        super(cause);
    }
}
