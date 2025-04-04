package org.javaguru.travel.insurance.core.validation;

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
public class AgreementDateToValidatorTest {

    @Mock
    private ErrorBuilderFactory errorBuilderFactory;

    @InjectMocks
    private AgreementDateToValidator validator;

    @Test
    void shouldReturnErrorWhenDateToIsNull(){
        TravelCalculatePremiumRequest request = createRequestMock();
        Mockito.when(errorBuilderFactory.buildError("ERROR_CODE_4"))
                .thenReturn(new ValidationError("ERROR_CODE_4",
                        "Field agreementDateTo must not be empty!"));
        Mockito.when(request.getAgreementDateTo()).thenReturn(null);
        Optional<ValidationError> result = validator.execute(request);
        assertTrue(result.isPresent());
        assertEquals(result.get().getErrorCode(), "ERROR_CODE_4");
        assertEquals(result.get().getDescription(), "Field agreementDateTo must not be empty!");
    }

    private TravelCalculatePremiumRequest createRequestMock() {
        return Mockito.mock(TravelCalculatePremiumRequest.class);
    }

}
