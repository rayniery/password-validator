package rayniery.password.rule;

public class AllowedLetters implements ValidationRule {
    private final String allowed;

    public AllowedLetters(String allowed) {
        this.allowed = allowed;
    }

    @Override
    public ValidationResult validate(String password) {
        for (char letter : password.toCharArray()) {
            // if letter is not among the allowed ones, returns an error.
            if (allowed.indexOf(letter) < 0) {
                return ValidationResult.errorCode(ValidationError.NOT_ALLOWED,
                        "Only lowercase letters and digits allowed");
            }
        }
        return ValidationResult.valid();
    }
}
