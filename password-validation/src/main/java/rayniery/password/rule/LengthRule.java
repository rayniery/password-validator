package rayniery.password.rule;

public class LengthRule implements ValidationRule {
    private final int maxLenght;
    private final int minLenght;

    public LengthRule(int minLenght, int maxLength) {
        this.maxLenght = maxLength;
        this.minLenght = minLenght;
    }

    @Override
    public ValidationResult validate(String password) {
        int length = password.length();
        if (length < minLenght) {
            return ValidationResult.errorCode(ValidationError.LENGTH, tooShort(length));
        } else if (length > maxLenght) {
            return ValidationResult.errorCode(ValidationError.LENGTH, tooLong(length));
        }
        return ValidationResult.valid();
    }

    private String tooShort(int length) {
        return "Password is too SHORT. Length is " + length +
                ", required at least " + minLenght;
    }

    private String tooLong(int length) {
        return "Password is too LONG. Length is " + length +
                ", required at most " + maxLenght;
    }
}
