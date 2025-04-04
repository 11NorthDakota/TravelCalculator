package org.javaguru.travel.insurance.core.RequestValidators;

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

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class DateToAfterDateFromValidatorTest {

    @Mock
    private ErrorBuilder errorBuilder;

    @InjectMocks
    private DateToAfterDateFromValidator validator;

    @Test
    void shouldReturnErrorWhenDateToBeforeDateFrom(){
        TravelCalculatePremiumRequest request = createRequestMock();
        Mockito.when(errorBuilder.buildError("ERROR_CODE_10"))
                .thenReturn(new ValidationError("ERROR_CODE_10",
                        "AgreementDateFrom must be less then agreementDateTo"));
        Mockito.when(request.getAgreementDateTo()).thenReturn(LocalDate.of(2025,12,24));
        Mockito.when(request.getAgreementDateFrom()).thenReturn(LocalDate.of(2025,12,25));
        Optional<ValidationError> errors = validator.execute(request);
        assertTrue(errors.isPresent());
        assertEquals(errors.get().getErrorCode(),"ERROR_CODE_10");
        assertEquals(errors.get().getDescription(), "AgreementDateFrom must be less then agreementDateTo");
    }

    @Test
    void shouldNotReturnErrorWhenDateToAfterDateFrom(){
        TravelCalculatePremiumRequest request = createRequestMock();
        Mockito.when(request.getAgreementDateTo()).thenReturn(LocalDate.of(2025,12,30));
        Mockito.when(request.getAgreementDateFrom()).thenReturn(LocalDate.of(2025,12,25));
        Optional<ValidationError> errors = validator.execute(request);
        assertTrue(errors.isEmpty());
    }

    @Test
    void shouldReturnErrorWhenDateToEqualsDateFrom(){
        TravelCalculatePremiumRequest request = createRequestMock();
        Mockito.when(errorBuilder.buildError("ERROR_CODE_10"))
                .thenReturn(new ValidationError("ERROR_CODE_10",
                        "AgreementDateFrom must be less then agreementDateTo"));
        Mockito.when(request.getAgreementDateFrom()).thenReturn(LocalDate.of(2025,12,25));
        Mockito.when(request.getAgreementDateTo()).thenReturn(LocalDate.of(2025,12,25));
        Optional<ValidationError> errors = validator.execute(request);
        assertTrue(errors.isPresent());
        assertEquals(errors.get().getErrorCode(),"ERROR_CODE_10");
        assertEquals(errors.get().getDescription(), "AgreementDateFrom must be less then agreementDateTo");
    }

    private TravelCalculatePremiumRequest createRequestMock(){
        return Mockito.mock(TravelCalculatePremiumRequest.class);
    }

}
