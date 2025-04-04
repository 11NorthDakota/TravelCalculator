package org.javaguru.travel.insurance.core;

import lombok.RequiredArgsConstructor;
import org.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class TravelPremiumCalculateUnderwriting {

    private final DateTimeService dts;

    public BigDecimal calculatePremium(TravelCalculatePremiumRequest request) {
        return BigDecimal.valueOf(dts.calculateDaysBetween(
                request.getAgreementDateFrom(), request.getAgreementDateTo()));
    }

}
