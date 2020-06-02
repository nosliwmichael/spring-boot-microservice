package com.aperture.validator.builders;

import com.aperture.validator.validators.NumericValidator;

interface ValidatorBuilderNumber {

    default ValidatorBuilder isEqualToNumber(Number source, Number number) {
        if (!NumericValidator.isEqualTo(source, number)) {
            ValidatorBuilder.invalidate();
            ValidatorBuilder.recordFailedTest("isEqualToNumber");
        }
        return ValidatorBuilder.getInstance();
    }

    default ValidatorBuilder isLessThan(Number source, Number number) {
        if (!NumericValidator.isLessThan(source, number)) {
            ValidatorBuilder.invalidate();
            ValidatorBuilder.recordFailedTest("isLessThan");
        }
        return ValidatorBuilder.getInstance();
    }

    default ValidatorBuilder isGreaterThan(Number source, Number number) {
        if (!NumericValidator.isGreaterThan(source, number)) {
            ValidatorBuilder.invalidate();
            ValidatorBuilder.recordFailedTest("isGreaterThan");
        }
        return ValidatorBuilder.getInstance();
    }

}
