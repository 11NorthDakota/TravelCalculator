package org.javaguru.travel.insurance.core.service;

import org.javaguru.travel.insurance.core.underwriting.TravelPremiumUnderwriting;
import org.javaguru.travel.insurance.core.validation.TravelCalculatePremiumRequestValidator;
import org.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class TravelCalculatePremiumServiceImplTest {

    @Mock
    private TravelPremiumUnderwriting underwritingCalculator;
    @Mock
    private TravelCalculatePremiumRequestValidator validator;

    @InjectMocks
    private TravelCalculatePremiumServiceImpl service;

    private final TravelCalculatePremiumRequest request = getRequestWithAllParam();


    @Test
    public void calculatePremiumFirstNameTest() {
        Mockito.when(underwritingCalculator.calculatePremium(request)).thenReturn(BigDecimal.valueOf(0));
        assertEquals(service.calculatePremium(request).getPersonFirstName(),request.getPersonFirstName());
    }
    @Test
    public void calculatePremiumLastNameTest() {
        Mockito.when(underwritingCalculator.calculatePremium(request)).thenReturn(BigDecimal.valueOf(0));
        assertEquals(service.calculatePremium(request).getPersonLastName(),request.getPersonLastName());
    }
    @Test
    public void calculatePremiumDateFromTest() {
        Mockito.when(underwritingCalculator.calculatePremium(request)).thenReturn(BigDecimal.valueOf(0));
        assertEquals(service.calculatePremium(request).getAgreementDateFrom(),request.getAgreementDateFrom());
    }
    @Test
    public void calculatePremiumDateToTest() {
        Mockito.when(underwritingCalculator.calculatePremium(request)).thenReturn(BigDecimal.valueOf(0));
        assertEquals(service.calculatePremium(request).getAgreementDateTo(),request.getAgreementDateTo());
    }
    @Test
    public void calculatePremiumAgreementPriceTest() {
        Mockito.when(underwritingCalculator.calculatePremium(request)).thenReturn(BigDecimal.valueOf(0));
        assertEquals(service.calculatePremium(request).getAgreementPrice(), BigDecimal.valueOf(0));
    }

    private TravelCalculatePremiumRequest getRequestWithAllParam(){
        return new TravelCalculatePremiumRequest(
                "John",
                "Green",
                LocalDate.now(),
                LocalDate.now(),
                List.of("TRAVEL_MEDICAL", "TRAVEL_CANCELLATION", "TRAVEL_LOSS_BAGGAGE")
        );
    }
}