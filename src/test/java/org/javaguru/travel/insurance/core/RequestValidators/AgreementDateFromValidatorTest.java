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
public class AgreementDateFromValidatorTest {

    @Mock
    private ErrorBuilder errorBuilder;

    @InjectMocks
    private AgreementDateFromValidator validator;

    @Test
    void shouldReturnErrorWhenDateFromIsNull(){
        TravelCalculatePremiumRequest request = createRequestMock();
        Mockito.when(errorBuilder.buildError("ERROR_CODE_2"))
                .thenReturn(new ValidationError("ERROR_CODE_2",
                        "Field agreementDateFrom must not be empty!"));
        Mockito.when(request.getAgreementDateFrom()).thenReturn(null);
        Optional<ValidationError> result = validator.execute(request);
        assertTrue(result.isPresent());
        assertEquals(result.get().getErrorCode(),"ERROR_CODE_2");
        assertEquals(result.get().getDescription(),
                "Field agreementDateFrom must not be empty!");
    }

    private TravelCalculatePremiumRequest createRequestMock(){
        return Mockito.mock(TravelCalculatePremiumRequest.class);
    }

}
