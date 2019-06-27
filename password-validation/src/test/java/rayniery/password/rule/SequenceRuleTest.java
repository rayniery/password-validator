package rayniery.password.rule;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SequenceRuleTest {
    @Test
    public void shouldRejectRepeatedSequence() {
        ValidationRule rule = new SequenceRule();
        assertThat(rule.validate("11abcdef").isValid(), is(false));
        assertThat(rule.validate("123123abcdef").isValid(), is(false));
        assertThat(rule.validate("12abbb34b").isValid(), is(false));
        assertThat(rule.validate("ABDee").isValid(), is(false));
    }

    @Test
    public void shouldAcceptNonConsecutiveSequence() {
        ValidationRule rule = new SequenceRule();
        assertThat(rule.validate("123abc123def").isValid(), is(true));
        assertThat(rule.validate("567890abc567890").isValid(), is(true));
    }
}
