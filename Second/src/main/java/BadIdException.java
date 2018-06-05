public class BadIdException extends Exception {
    public BadIdException() {
    }

    public BadIdException(String message) {
        super(message);
    }

    public BadIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadIdException(Throwable cause) {
        super(cause);
    }
}
