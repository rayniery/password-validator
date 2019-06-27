package rayniery.password.rule;

public final class ValidationResult {
    private final boolean valid;
    private final String errorMsg;
    private final ValidationError errorCode;

    private ValidationResult(boolean valid, String errorMsg, ValidationError errorCode) {
        this.valid = valid;
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    public static ValidationResult valid() {
        return new ValidationResult(true, "", ValidationError.NO_ERROR);
    }

    public static ValidationResult errorCode(ValidationError error, String msg) {
        return new ValidationResult(false, msg, error);
    }

    public boolean isValid() {
        return valid;
    }

    public ValidationError getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
