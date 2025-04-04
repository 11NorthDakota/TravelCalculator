package org.javaguru.travel.insurance.core.RequestValidators;

import org.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.dto.ValidationError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class PersonFirstNameValidatorTest {

    @Mock
    private ErrorBuilder errorBuilder;

    @InjectMocks
    private PersonFirstNameValidator validator;

    @Test
    void shouldReturnErrorWhenFirstNameIsNull() {
        TravelCalculatePremiumRequest request = createRequestMock();
        Mockito.when(errorBuilder.buildError("ERROR_CODE_7"))
                .thenReturn(new ValidationError("ERROR_CODE_7",
                        "Field personFirstName must not be empty!"));
        Mockito.when(request.getPersonFirstName()).thenReturn(null);
        Optional<ValidationError> result = validator.execute(request);
        assertTrue(result.isPresent());
        assertEquals(result.get().getErrorCode(), "ERROR_CODE_7");
        assertEquals(result.get().getDescription(), "Field personFirstName must not be empty!");
    }


    @Test
    void shouldReturnErrorWhenFirstNameIsEmpty() {
        TravelCalculatePremiumRequest request = createRequestMock();
        Mockito.when(errorBuilder.buildError("ERROR_CODE_7"))
                .thenReturn(new ValidationError("ERROR_CODE_7",
                        "Field personFirstName must not be empty!"));
        Mockito.when(request.getPersonFirstName()).thenReturn("");
        Optional<ValidationError> result = validator.execute(request);
        assertTrue(result.isPresent());
        assertEquals(result.get().getErrorCode(), "ERROR_CODE_7");
        assertEquals(result.get().getDescription(), "Field personFirstName must not be empty!");

    }

    @Test
    void shouldNotReturnErrorWhenFirstNameIsValid() {
        TravelCalculatePremiumRequest request = createRequestMock();
        Mockito.when(request.getPersonFirstName()).thenReturn("John");
        Optional<ValidationError> result = validator.execute(request);
        assertFalse(result.isPresent());
    }

    private TravelCalculatePremiumRequest createRequestMock() {
        return Mockito.mock(TravelCalculatePremiumRequest.class);
    }
}
