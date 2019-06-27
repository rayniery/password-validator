package rayniery.password.rule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SequenceRule implements ValidationRule {
    private static final Pattern REGEX = Pattern.compile("(.{1,})\\1");

    public SequenceRule() { }

    @Override
    public ValidationResult validate(String password) {
        final Matcher matcher = REGEX.matcher(password);
        if (matcher.find()) {
            return ValidationResult.errorCode(ValidationError.REPEATED_LETTERS, matcher.group());
        }
        return ValidationResult.valid();
    }
}
