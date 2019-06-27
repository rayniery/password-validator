package rayniery.password.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rayniery.password.PasswordValidation;
import rayniery.password.rule.*;

@Configuration
public class PasswordValidationConfig {

    @Bean
    public PasswordValidation passwordValidator() {
        return new PasswordValidation(
                // length must be between 5 and 12
                new LengthRule(5, 12),

                // must consist of at least one lowercase letter
                new LowercaseRule(1),

                // must consist of at least one numerical digit
                new NumericalDigitsRule(1),

                // must consist ONLY of lowercase letters and digits
                new AllowedLetters(LowercaseRule.LETTERS + NumericalDigitsRule.DIGITS),

                // must not contain any sequence of characters immediately followed by the same sequence
                new SequenceRule()
        );
    }
}
