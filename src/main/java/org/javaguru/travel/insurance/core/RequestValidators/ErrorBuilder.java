package org.javaguru.travel.insurance.core.RequestValidators;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.javaguru.travel.insurance.dto.ValidationError;
import org.javaguru.travel.insurance.util.ErrorCodeUtil;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class ErrorBuilder {

    private final ErrorCodeUtil errorCodeUtil;

    public ValidationError buildError(String errorCode){
        String errorDesc = errorCodeUtil.getErrorDesc(errorCode);
        return new ValidationError(errorCode,errorDesc);
    }
}
