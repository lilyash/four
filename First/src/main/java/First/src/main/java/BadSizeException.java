public class BadSizeException extends Throwable {
    public BadSizeException() {
    }

    public BadSizeException(String message) {
        super(message);
    }

    public BadSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadSizeException(Throwable cause) {
        super(cause);
    }
}
