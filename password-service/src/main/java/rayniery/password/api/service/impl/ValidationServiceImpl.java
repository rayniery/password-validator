package rayniery.password.api.service.impl;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rayniery.password.PasswordValidation;
import rayniery.password.api.model.ValidationRequest;
import rayniery.password.api.model.ValidationResponse;
import rayniery.password.api.service.ValidationService;
import rayniery.password.rule.ValidationError;
import rayniery.password.rule.ValidationResult;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ValidationServiceImpl implements ValidationService {
    private final PasswordValidation passwordValidator;

    @Autowired
    public ValidationServiceImpl(PasswordValidation passwordValidator) {
        this.passwordValidator = passwordValidator;
    }

    @Override
    public ValidationResponse validate(ValidationRequest request) {

        List<ValidationResult> result = passwordValidator.validate(request.getPassword());
        List<ValidationResult> errors = result.stream()
                .filter(r -> !r.isValid())
                .collect(Collectors.toList());

        return ValidationResponse.builder()
                .valid(errors.isEmpty())
                .errors(
                        errors.stream()
                        .map(r -> new Pair<>(r.getErrorCode(), r.getErrorMsg()))
                        .collect(Collectors.toList())
                )
                .build();
    }
}
