package org.javaguru.travel.insurance.core.RequestValidators;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.dto.ValidationError;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class PersonFirstNameValidator implements ValidationCore{

    private final ErrorBuilder errorBuilder;

    public Optional<ValidationError> execute(
            TravelCalculatePremiumRequest request) {
        return (request.getPersonFirstName() == null || request.getPersonFirstName().isEmpty())
                ? Optional.of(errorBuilder.buildError("ERROR_CODE_7"))
                : Optional.empty();
    }
}
