package org.javaguru.travel.insurance.core.RequestValidators;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.dto.ValidationError;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class PersonLastNameValidator implements ValidationCore {

    private final ErrorBuilder errorBuilder;

    public Optional<ValidationError> execute(
            TravelCalculatePremiumRequest request) {
        return (request.getPersonLastName() == null || request.getPersonLastName().isEmpty())
                ? Optional.of(errorBuilder.buildError("ERROR_CODE_8"))
                : Optional.empty();
    }
}
