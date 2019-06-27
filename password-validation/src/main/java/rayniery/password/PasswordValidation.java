package rayniery.password;

import rayniery.password.rule.ValidationResult;
import rayniery.password.rule.ValidationRule;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PasswordValidation {
    private final List<ValidationRule> validationRules;

    public PasswordValidation(ValidationRule... validationRules) {
        this.validationRules = Arrays.asList(validationRules);
    }

    public List<ValidationResult> validate(String password) {
        return validationRules.stream()
                .map(r -> r.validate(password))
                .collect(Collectors.toList());
    }
}
