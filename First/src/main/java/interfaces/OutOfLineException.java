package interfaces;

public class OutOfLineException extends MatrixException {
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
