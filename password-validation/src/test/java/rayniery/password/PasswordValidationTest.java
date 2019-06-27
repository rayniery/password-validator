package rayniery.password;

import org.junit.Test;
import rayniery.password.rule.LengthRule;
import rayniery.password.rule.LowercaseRule;
import rayniery.password.rule.ValidationResult;
import rayniery.password.rule.ValidationRule;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PasswordValidationTest {
    @Test
    public void ShouldApplyOneRuleCorrectly() {
        final String pswd = "aBcDeFg";
        final int letters = 3;

        ValidationRule lowercase = new LowercaseRule(letters);
        ValidationResult ruleResult = lowercase.validate(pswd);

        PasswordValidation passwordValidation = new PasswordValidation(lowercase);
        List<ValidationResult> pvResults = passwordValidation.validate(pswd);

        assertThat(pvResults.size(), is(1));
        assertThat(pvResults.get(0).isValid(), is(ruleResult.isValid()));
    }

    @Test
    public void shouldApplySeveralRulesCorrectly() {
        final String pswd = "aBcDeFg";
        final int letters = 3;

        ValidationRule lowercase = new LowercaseRule(letters);
        ValidationResult lowerResult = lowercase.validate(pswd);

        ValidationRule length = new LengthRule(3, 6);
        ValidationResult lengthResult = length.validate(pswd);

        PasswordValidation passwordValidation = new PasswordValidation(lowercase, length);
        List<ValidationResult> pvResults = passwordValidation.validate(pswd);

        assertThat(pvResults.size(), is(2));
        assertThat(pvResults.get(0).isValid(), is(lowerResult.isValid()));
        assertThat(pvResults.get(1).isValid(), is(lengthResult.isValid()));
    }
}
