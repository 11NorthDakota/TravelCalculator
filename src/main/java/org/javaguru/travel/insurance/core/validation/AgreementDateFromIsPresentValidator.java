package org.javaguru.travel.insurance.core.validation;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.dto.ValidationError;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;
@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class AgreementDateFromIsPresentValidator implements ValidationCore{

    private final ErrorBuilderFactory errorBuilderFactory;

    public Optional<ValidationError> execute(TravelCalculatePremiumRequest request) {
        return (request.getAgreementDateFrom() != null && request.getAgreementDateFrom().isAfter(LocalDate.now()))
                ? Optional.empty()
                : Optional.of(errorBuilderFactory.buildError("ERROR_CODE_5"));
    }
}
