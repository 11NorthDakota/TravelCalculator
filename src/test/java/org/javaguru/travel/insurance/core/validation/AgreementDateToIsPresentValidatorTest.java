package org.javaguru.travel.insurance.core.validation;

import org.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.dto.ValidationError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(MockitoExtension.class)
public class AgreementDateToIsPresentValidatorTest {

    @Mock
    private ErrorBuilderFactory errorBuilderFactory;

    @InjectMocks
    private AgreementDateToValidator validator;


    @Test
    void shouldNotReturnErrorWhenDateToIsPresent(){
        TravelCalculatePremiumRequest request = createRequestMock();
        Mockito.when(request.getAgreementDateTo()).thenReturn(LocalDate.of(2025,12,30));
        Optional<ValidationError> result = validator.execute(request);
        assertFalse(result.isPresent());
    }

    private TravelCalculatePremiumRequest createRequestMock() {
        return Mockito.mock(TravelCalculatePremiumRequest.class);
    }
}
