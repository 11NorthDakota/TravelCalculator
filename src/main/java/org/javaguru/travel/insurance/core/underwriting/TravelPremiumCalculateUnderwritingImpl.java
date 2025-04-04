package org.javaguru.travel.insurance.core.underwriting;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.util.DateTimeUtil;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class TravelPremiumCalculateUnderwritingImpl implements TravelPremiumUnderwriting {

    private final DateTimeUtil dts;

    public BigDecimal calculatePremium(TravelCalculatePremiumRequest request) {
        return BigDecimal.valueOf(dts.calculateDaysBetween(
                request.getAgreementDateFrom(), request.getAgreementDateTo()));
    }

}
