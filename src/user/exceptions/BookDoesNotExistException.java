package user.exceptions;

public class BookDoesNotExistException extends Throwable {
    public BookDoesNotExistException() {
    }

    public BookDoesNotExistException(String message) {
        super(message);
    }

    public BookDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookDoesNotExistException(Throwable cause) {
        super(cause);
    }

    public BookDoesNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
