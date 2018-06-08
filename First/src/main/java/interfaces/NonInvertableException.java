package interfaces;

public class NonInvertableException extends MatrixException {
    public NonInvertableException() {
        super();
    }

    public NonInvertableException(String message) {
        super(message);
    }

    public NonInvertableException(String message, Throwable cause) {
        super(message, cause);
    }

    public NonInvertableException(Throwable cause) {
        super(cause);
    }
}
