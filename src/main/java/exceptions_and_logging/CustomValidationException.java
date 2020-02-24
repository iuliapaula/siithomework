package exceptions_and_logging;

public class CustomValidationException extends RuntimeException {
    public CustomValidationException() {
    }

    public CustomValidationException(String message) {
        super(message);
    }
}
