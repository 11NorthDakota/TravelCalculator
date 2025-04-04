package org.javaguru.travel.insurance.core.RequestValidators;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.dto.ValidationError;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class TravelCalculatePremiumRequestValidatorImpl implements TravelCalculatePremiumRequestValidator {

    private final List<ValidationCore> travelValidations;

    @Override
    public List<ValidationError> validate(TravelCalculatePremiumRequest request) {

        return travelValidations.stream()
                .map(validator-> validator.execute(request))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

    }

}
