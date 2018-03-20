public class OutOfLineException extends Exception {
    public OutOfLineException() {
    }

    public OutOfLineException(String message) {
        super(message);
    }

    public OutOfLineException(String message, Throwable cause) {
        super(message, cause);
    }

    public OutOfLineException(Throwable cause) {
        super(cause);
    }
}
