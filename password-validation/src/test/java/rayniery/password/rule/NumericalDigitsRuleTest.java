package rayniery.password.rule;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class NumericalDigitsRuleTest {
    @Test
    public void shouldAcceptPswdWithLowercase() {
        ValidationRule rule = new NumericalDigitsRule(1);
        ValidationResult validation = rule.validate("AB5DEF");
        assertThat(validation.isValid(), is(true));
    }

    @Test
    public void shouldRejectPswdWithNotEnoughLowercase() {
        ValidationRule rule = new NumericalDigitsRule(5);
        ValidationResult validation = rule.validate("Ab1cD2e3Fg4");
        assertThat(validation.isValid(), is(false));
        assertThat(validation.getErrorCode(), is(ValidationError.NOT_ALLOWED));
    }

    @Test
    public void shouldAcceptPswdWithMoreLowercaseThanRequired() {
        ValidationRule rule = new NumericalDigitsRule(3);
        ValidationResult validation = rule.validate("1ABcD6eFghi0");
        assertThat(validation.isValid(), is(true));
    }
}
