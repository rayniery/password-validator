package rayniery.password;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rayniery.password.api.ValidationEndpoint;
import rayniery.password.api.model.ValidationRequest;
import rayniery.password.api.model.ValidationResponse;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTest {

    @Autowired
    ValidationEndpoint endpoint;

    @Test
    public void shouldRejectInvalidPasswords() {
        // sequence errors
        ValidationRequest request1 = ValidationRequest.builder()
                .password("123123abcdef")
                .build();
        ValidationRequest request2 = ValidationRequest.builder()
                .password("11abcdef")
                .build();
        ValidationRequest request3 = ValidationRequest.builder()
                .password("12abbb34b")
                .build();
        // upper case
        ValidationRequest request4 = ValidationRequest.builder()
                .password("ABCDEF")
                .build();
        // too short
        ValidationRequest request5 = ValidationRequest.builder()
                .password("ab12")
                .build();
        // too long
        ValidationRequest request6 = ValidationRequest.builder()
                .password("abcdefghi1234")
                .build();

        ValidationResponse response1 = endpoint.validate(request1).getBody();
        ValidationResponse response2 = endpoint.validate(request2).getBody();
        ValidationResponse response3 = endpoint.validate(request3).getBody();
        ValidationResponse response4 = endpoint.validate(request4).getBody();
        ValidationResponse response5 = endpoint.validate(request5).getBody();
        ValidationResponse response6 = endpoint.validate(request6).getBody();

        assertFalse(response1.isValid());
        assertFalse(response2.isValid());
        assertFalse(response3.isValid());
        assertFalse(response4.isValid());
        assertFalse(response5.isValid());
        assertFalse(response6.isValid());
    }

    @Test
    public void shouldAcceptValidPasswords() {
        ValidationRequest request1 = ValidationRequest.builder()
                .password("123abc123def")
                .build();
        ValidationRequest request2 = ValidationRequest.builder()
                .password("1234a")
                .build();

        ValidationResponse response1 = endpoint.validate(request1).getBody();
        ValidationResponse response2 = endpoint.validate(request2).getBody();

        assertTrue(response1.isValid());
        assertTrue(response2.isValid());
    }
}