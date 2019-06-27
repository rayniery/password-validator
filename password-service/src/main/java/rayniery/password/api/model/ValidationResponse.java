package rayniery.password.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import javafx.util.Pair;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import rayniery.password.rule.ValidationError;

import java.util.List;

@Value
@Builder(builderClassName = "ValidationResponseBuilder", toBuilder = true)
@AllArgsConstructor
@JsonDeserialize(builder = ValidationResponse.ValidationResponseBuilder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValidationResponse {

    private boolean valid;
    private List<Pair<ValidationError, String>> errors;

    @JsonPOJOBuilder(withPrefix = "")
    public static class ValidationResponseBuilder {
    }
}
