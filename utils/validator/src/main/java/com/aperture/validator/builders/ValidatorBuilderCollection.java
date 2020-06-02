package com.aperture.validator.builders;

import com.aperture.validator.validators.ListValidator;

import java.util.Collection;

interface ValidatorBuilderCollection {

    default ValidatorBuilder doesContain(Collection<?> source, Object reference) {
        if (!ListValidator.doesContain(source, reference)) {
            ValidatorBuilder.invalidate();
            ValidatorBuilder.recordFailedTest("doesContain");
        }
        return ValidatorBuilder.getInstance();
    }

    default ValidatorBuilder doesContainAll(Collection<?> source, Collection<?> reference) {
        if (!ListValidator.doesContainAll(source, reference)) {
            ValidatorBuilder.invalidate();
            ValidatorBuilder.recordFailedTest("doesContain");
        }
        return ValidatorBuilder.getInstance();
    }

}
