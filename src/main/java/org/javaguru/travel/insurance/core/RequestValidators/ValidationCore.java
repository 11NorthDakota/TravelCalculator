package org.javaguru.travel.insurance.core.RequestValidators;

import org.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.dto.ValidationError;

import java.util.Optional;

interface ValidationCore {

    Optional<ValidationError> execute(TravelCalculatePremiumRequest request);

}
