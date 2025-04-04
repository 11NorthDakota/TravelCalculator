package org.javaguru.travel.insurance.core.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.javaguru.travel.insurance.core.underwriting.TravelPremiumUnderwriting;
import org.javaguru.travel.insurance.core.validation.TravelCalculatePremiumRequestValidator;
import org.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.dto.TravelCalculatePremiumResponse;
import org.javaguru.travel.insurance.dto.ValidationError;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class TravelCalculatePremiumServiceImpl implements TravelCalculatePremiumService {

    private final TravelPremiumUnderwriting underwritingCalculator;
    private final TravelCalculatePremiumRequestValidator validator;

    @Override
    public TravelCalculatePremiumResponse calculatePremium(TravelCalculatePremiumRequest request) {
        List<ValidationError> errors = validator.validate(request);
        BigDecimal underwriting = underwritingCalculator.calculatePremium(request);
        return errors.isEmpty() ? createResponse(request, underwriting) : createResponse(errors);
    }

    private TravelCalculatePremiumResponse createResponse(List<ValidationError> errors) {
        return new TravelCalculatePremiumResponse(errors);
    }

    private TravelCalculatePremiumResponse createResponse(TravelCalculatePremiumRequest request,
                                                          BigDecimal underwriting) {

        return new TravelCalculatePremiumResponse(
                request.getPersonFirstName(),
                request.getPersonLastName(),
                request.getAgreementDateFrom(),
                request.getAgreementDateTo(),
                underwriting);
    }

}
