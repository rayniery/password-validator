package rayniery.password.rule;

public interface ValidationRule {
    ValidationResult validate(String password);
}
