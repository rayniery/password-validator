package rayniery.password.rule;

public final class RuleUtils {
    private RuleUtils() { }

    /**
     * Validate if password has at least 'occurrences' number of letters of dict.
     * @param password
     * @param dict
     * @param occurrences
     * @return
     */
    public static ValidationResult validateMinimumLetters(String password, String dict, int occurrences) {
        int numberOfLowercaseLetters = numberOfLetters(password, dict, occurrences).length();

        if (numberOfLowercaseLetters < occurrences) {
            return ValidationResult.errorCode(ValidationError.NOT_ALLOWED,
                    "At least " + occurrences + " letter or digits");
        }
        return ValidationResult.valid();
    }

    /**
     * Returns a string with the permitted chars within pswd which are elements of param allowed.
     * @param pswd
     * @param allowed
     * @param occurrences
     * @return
     */
    public static String numberOfLetters(final String pswd, String allowed, int occurrences) {
        final StringBuilder result = new StringBuilder(pswd.length());
        for (int i = 0; i < pswd.length(); i++) {
            final char c = pswd.charAt(i);
            if (allowed.indexOf(c) != -1) {
                if (result.length() < occurrences) {
                    result.append(c);
                } else {
                    break;
                }
            }
        }
        return result.toString();
    }
}
