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
public class PersonLastNameValidatorTest {

    @Mock
    private ErrorBuilder errorBuilder;

    @InjectMocks
    private PersonLastNameValidator validator;


    @Test
    void shouldReturnErrorWhenLastNameIsNull() {
        TravelCalculatePremiumRequest request = createRequestMock();
        Mockito.when(errorBuilder.buildError("ERROR_CODE_8"))
                .thenReturn(new ValidationError("ERROR_CODE_8",
                        "Field personLastName must not be empty!"));
        Mockito.when(request.getPersonLastName()).thenReturn(null);
        Optional<ValidationError> result = validator.execute(request);
        assertTrue(result.isPresent());
        assertEquals(result.get().getErrorCode(),"ERROR_CODE_8");
        assertEquals(result.get().getDescription(),"Field personLastName must not be empty!");
    }

    @Test
    void shouldReturnErrorWhenLastNameIsEmpty() {
        TravelCalculatePremiumRequest request = createRequestMock();
        Mockito.when(errorBuilder.buildError("ERROR_CODE_8"))
                .thenReturn(new ValidationError("ERROR_CODE_8",
                        "Field personLastName must not be empty!"));
        Mockito.when(request.getPersonLastName()).thenReturn("");
        Optional<ValidationError> result = validator.execute(request);
        assertTrue(result.isPresent());
        assertEquals(result.get().getErrorCode(),"ERROR_CODE_8");
        assertEquals(result.get().getDescription(),"Field personLastName must not be empty!");
    }

    @Test
    void shouldNotReturnErrorWhenLastNameIsPresent() {
        TravelCalculatePremiumRequest request = createRequestMock();
        Mockito.when(request.getPersonLastName()).thenReturn("Green");
        Optional<ValidationError> result = validator.execute(request);
        assertFalse(result.isPresent());

    }

    private TravelCalculatePremiumRequest createRequestMock() {
        return Mockito.mock(TravelCalculatePremiumRequest.class);
    }
}
