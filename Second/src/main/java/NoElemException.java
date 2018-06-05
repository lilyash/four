public class NoElemException extends Exception {
    public NoElemException() {
    }

    public NoElemException(String message) {
        super(message);
    }

    public NoElemException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoElemException(Throwable cause) {
        super(cause);
    }
}
