package org.javaguru.travel.insurance.core.validation;

import org.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.dto.ValidationError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class SelectedRisksValidatorTest {

    @Mock
    private ErrorBuilderFactory errorBuilderFactory;

    @InjectMocks
    private SelectedRisksValidator validator;


    @Test
    void shouldReturnErrorWhenSelectedRisksIsNull(){
        TravelCalculatePremiumRequest request = createRequest();
        Mockito.when(errorBuilderFactory.buildError("ERROR_CODE_6"))
                .thenReturn(new ValidationError("ERROR_CODE_6","At least 1 risk must be selected"));
        Mockito.when(request.getSelectedRisks()).thenReturn(null);
        Optional<ValidationError> result =  validator.execute(request);
        assertTrue(result.isPresent());
        assertEquals(result.get().getErrorCode(),"ERROR_CODE_6");
        assertEquals(result.get().getDescription(), "At least 1 risk must be selected");
    }

    @Test
    void shouldReturnErrorWhenSelectedRisksIsEmpty(){
        TravelCalculatePremiumRequest request = createRequest();
        Mockito.when(errorBuilderFactory.buildError("ERROR_CODE_6"))
                .thenReturn(new ValidationError("ERROR_CODE_6","At least 1 risk must be selected"));
        Mockito.when(request.getSelectedRisks()).thenReturn(List.of());
        Optional<ValidationError> result =  validator.execute(request);
        assertTrue(result.isPresent());
        assertEquals(result.get().getErrorCode(),"ERROR_CODE_6");
        assertEquals(result.get().getDescription(), "At least 1 risk must be selected");
    }

    @Test
    void shouldSuccessWhenRisksSelected(){
        TravelCalculatePremiumRequest request = createRequest();
        Mockito.when(request.getSelectedRisks())
                .thenReturn(List.of("TRAVEL_MEDICAL", "TRAVEL_CANCELLATION", "TRAVEL_LOSS_BAGGAGE"));
        Optional<ValidationError> result = validator.execute(request);
        assertFalse(result.isPresent());
    }


    private TravelCalculatePremiumRequest createRequest(){
        return Mockito.mock(TravelCalculatePremiumRequest.class);
    }

}
