package rayniery.password.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rayniery.password.api.model.ValidationRequest;
import rayniery.password.api.model.ValidationResponse;
import rayniery.password.api.service.ValidationService;

import javax.validation.Valid;

@RestController
@RequestMapping(
        value = "/password",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class ValidationEndpoint {
    private final ValidationService service;

    @Autowired
    public ValidationEndpoint(ValidationService service) {
        this.service = service;
    }

    @GetMapping("ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("{\"password-service\": \"all good\"}");
    }

    @PostMapping("validation")
    public ResponseEntity<ValidationResponse> validate(@RequestBody @Valid ValidationRequest request) {
        return ResponseEntity.ok(service.validate(request));
    }
}
