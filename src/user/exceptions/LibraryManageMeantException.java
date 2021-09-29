package user.exceptions;

public class LibraryManageMeantException extends Exception {
    public LibraryManageMeantException() {
    }

    public LibraryManageMeantException(String message) {
        super(message);
    }

    public LibraryManageMeantException(String message, Throwable cause) {
        super(message, cause);
    }

    public LibraryManageMeantException(Throwable cause) {
        super(cause);
    }

    public LibraryManageMeantException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
