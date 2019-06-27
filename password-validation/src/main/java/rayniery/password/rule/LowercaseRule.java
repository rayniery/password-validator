package rayniery.password.rule;

import static rayniery.password.rule.RuleUtils.validateMinimumLetters;

public class LowercaseRule implements ValidationRule {
    public static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private final int numOfLetters;

    public LowercaseRule(int numOfLetters) {
        this.numOfLetters = numOfLetters;
    }

    @Override
    public ValidationResult validate(String password) {
        return validateMinimumLetters(password, LETTERS, numOfLetters);
    }
}
