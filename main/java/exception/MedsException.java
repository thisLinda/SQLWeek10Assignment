package exception;

public class MedsException extends RuntimeException {

    public MedsException() {
    }

    public MedsException(String message) {
        super(message);
    }

    public MedsException(Throwable cause) {
        super(cause);
    }

    public MedsException(String message, Throwable cause) {
        super(message, cause);
    }
}
