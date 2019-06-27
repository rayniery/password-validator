package rayniery.password.rule;

import org.junit.Test;
import static org.junit.Assert.*;

import static org.hamcrest.Matchers.*;

public class LengthRuleTest {

    @Test
    public void shouldReturnValid() {
        LengthRule rule = new LengthRule(5, 12);
        ValidationResult validation = rule.validate("ABCDEF");
        assertThat(validation.isValid(), is(true));
    }

    @Test
    public void shouldReturnTooShort() {
        LengthRule rule = new LengthRule(5, 12);
        ValidationResult validation = rule.validate("ABCD");
        assertThat(validation.isValid(), is(false));
        assertThat(validation.getErrorCode(), is(ValidationError.LENGTH));
    }

    @Test
    public void shouldReturnTooLong() {
        LengthRule rule = new LengthRule(5, 12);
        ValidationResult validation = rule.validate("ABCDEFGHIJKLMNOP");
        assertThat(validation.isValid(), is(false));
        assertThat(validation.getErrorCode(), is(ValidationError.LENGTH));
    }

    @Test
    public void shouldReturnValidWhenMinAndMaxEqual() {
        LengthRule rule = new LengthRule(7, 7);
        ValidationResult validation = rule.validate("ABCDEFG");
        assertThat(validation.isValid(), is(true));
    }
}
