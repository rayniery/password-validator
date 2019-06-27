package rayniery.password.rule;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class LowercaseRuleTest {
    @Test
    public void shouldAcceptPswdWithLowercase() {
        ValidationRule rule = new LowercaseRule(1);
        ValidationResult validation = rule.validate("ABcDEF");
        assertThat(validation.isValid(), is(true));
    }

    @Test
    public void shouldRejectPswdWithNotEnoughLowercase() {
        ValidationRule rule = new LowercaseRule(5);
        ValidationResult validation = rule.validate("AbcDeFg");
        assertThat(validation.isValid(), is(false));
        assertThat(validation.getErrorCode(), is(ValidationError.NOT_ALLOWED));
    }

    @Test
    public void shouldAcceptPswdWithMoreLowercaseThanRequired() {
        ValidationRule rule = new LowercaseRule(3);
        ValidationResult validation = rule.validate("ABcDeFghi");
        assertThat(validation.isValid(), is(true));
    }
}
