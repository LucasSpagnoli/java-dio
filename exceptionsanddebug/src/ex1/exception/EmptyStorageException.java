package ex1.exception;

public class EmptyStorageException extends RuntimeException {
    public EmptyStorageException(String message) {
        super(message);
    }
}
