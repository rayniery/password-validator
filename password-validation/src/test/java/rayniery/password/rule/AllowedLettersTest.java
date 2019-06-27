package rayniery.password.rule;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AllowedLettersTest {
    @Test
    public void shouldRejectNotAllowedLetter() {
        ValidationRule rule = new AllowedLetters("abcd");
        ValidationResult validation = rule.validate("bcde");
        assertThat(validation.isValid(), is(false));
    }

    @Test
    public void shouldAcceptAllowedLetter() {
        ValidationRule rule = new AllowedLetters("abcde");
        ValidationResult validation = rule.validate("bcde");
        assertThat(validation.isValid(), is(true));
    }
}
