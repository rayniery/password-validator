package rayniery.password.api.service;

import rayniery.password.api.model.ValidationRequest;
import rayniery.password.api.model.ValidationResponse;

public interface ValidationService {
    ValidationResponse validate(ValidationRequest request);
}
