# password-validator

Write a password validation service, meant to be configurable via IoC (using dependency injection engine of your choice). The service is meant to check a text string for compliance to any number of password validation rules. The rules currently known are:

- Must consist of a mixture of lowercase letters and numerical digits only, with at least one of each.

- Must be between 5 and 12 characters in length.

- Must not contain any sequence of characters immediately followed by the same sequence.

## Running the service
The implementation consists of mvn project with two modules:
 
1. **password-validation** is a standalone library that can be imported in other projects.
2. **password-service** is a simple REST API service that uses password-validation to validate passwords.

Run the following commands:
```
$> mvn clean install
$> cd password-service
$> mvn spring-boot:run
```  

The service will start listenning at http://localhost:8080. Now you can test passwords making POST requests to http://localhost:8080/api/password/validation:
```
{
	"password": "123abc123def"	
}
``` 

## Design
The password-validation library has a very simple yet extensible design. It has two main consists: a `ValidationRule` interface and a `PasswordValidation` class. The `PasswordValiation` class accepts a list of `ValidationRule` and validates a password against those rules. 

The password-service creates a `Password-Validation` Spring Bean with the following rules:

```
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
```