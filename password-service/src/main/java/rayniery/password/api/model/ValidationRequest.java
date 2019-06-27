package rayniery.password.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
@Builder(builderClassName = "ValidationRequestBuilder", toBuilder = true)
@AllArgsConstructor
@JsonDeserialize(builder = ValidationRequest.ValidationRequestBuilder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValidationRequest {

    @NotNull
    private String password;

    @JsonPOJOBuilder(withPrefix = "")
    public static class ValidationRequestBuilder {
    }
}
