package org.javaguru.travel.insurance.core.validation;

import org.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.dto.ValidationError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class TravelCalculatePremiumRequestValidatorImplTest {

    @InjectMocks
    private TravelCalculatePremiumRequestValidatorImpl validator;


    @Test
    public void shouldSuccess() {
        TravelCalculatePremiumRequest request = createRequestMock();

        ValidationCore validator1 = Mockito.mock(ValidationCore.class);
        ValidationCore validator2 = Mockito.mock(ValidationCore.class);
        ValidationCore validator3 = Mockito.mock(ValidationCore.class);

        Mockito.when(validator1.execute(request)).thenReturn(Optional.empty());
        Mockito.when(validator2.execute(request)).thenReturn(Optional.empty());
        Mockito.when(validator3.execute(request)).thenReturn(Optional.empty());

        List<ValidationCore> travelValidator = List.of(
                validator1,validator2,validator3
        );

        ReflectionTestUtils.setField(validator, "travelValidations", travelValidator);

        List<ValidationError> errors = validator.validate(request);
        assertTrue(errors.isEmpty());
    }

    @Test
    public void shouldFail() {
        TravelCalculatePremiumRequest request = createRequestMock();

        ValidationCore validator1 = Mockito.mock(ValidationCore.class);
        ValidationCore validator2 = Mockito.mock(ValidationCore.class);
        ValidationCore validator3 = Mockito.mock(ValidationCore.class);

        Mockito.when(validator1.execute(request)).thenReturn(Optional.of(new ValidationError()));
        Mockito.when(validator2.execute(request)).thenReturn(Optional.of(new ValidationError()));
        Mockito.when(validator3.execute(request)).thenReturn(Optional.of(new ValidationError()));

        List<ValidationCore> travelValidator = List.of(
                validator1,validator2,validator3
        );

        ReflectionTestUtils.setField(validator, "travelValidations", travelValidator);

        List<ValidationError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(),3);
    }


    private TravelCalculatePremiumRequest createRequestMock() {
        return Mockito.mock(TravelCalculatePremiumRequest.class);
    }


}