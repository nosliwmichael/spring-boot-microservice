package com.aperture.validator.builders;

import com.aperture.validator.validators.PatternValidator;

interface ValidatorBuilderPattern {

    default ValidatorBuilder isEmail(String source) {
        if (!PatternValidator.isEmail(source)) {
            ValidatorBuilder.invalidate();
            ValidatorBuilder.recordFailedTest("isEmail");
        }
        return ValidatorBuilder.getInstance();
    }

    default ValidatorBuilder isPhoneNumber(String source) {
        if (!PatternValidator.isPhoneNumber(source)) {
            ValidatorBuilder.invalidate();
            ValidatorBuilder.recordFailedTest("isPhoneNumber");
        }
        return ValidatorBuilder.getInstance();
    }

}
