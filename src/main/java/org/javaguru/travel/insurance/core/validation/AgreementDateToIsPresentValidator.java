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
class AgreementDateToIsPresentValidator implements ValidationCore{

    private final ErrorBuilderFactory errorBuilderFactory;

    public Optional<ValidationError> execute(TravelCalculatePremiumRequest request) {
        return (request.getAgreementDateTo() != null && request.getAgreementDateTo().isAfter(LocalDate.now()))
                ? Optional.empty()
                : Optional.of(errorBuilderFactory.buildError("ERROR_CODE_9"));
    }
}
