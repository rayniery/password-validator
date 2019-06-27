package rayniery.password.rule;

import static rayniery.password.rule.RuleUtils.validateMinimumLetters;

public class NumericalDigitsRule implements ValidationRule {
    public static final String DIGITS = "0123456789";
    private final int numOfDigits;

    public NumericalDigitsRule(int numOfDigits) {
        this.numOfDigits = numOfDigits;
    }

    @Override
    public ValidationResult validate(String password) {
        return validateMinimumLetters(password, DIGITS, numOfDigits);
    }
}
