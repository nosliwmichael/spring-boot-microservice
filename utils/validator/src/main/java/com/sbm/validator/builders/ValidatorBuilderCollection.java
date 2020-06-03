package com.sbm.validator.builders;

import com.sbm.validator.validators.CollectionValidator;

import java.util.Collection;

interface ValidatorBuilderCollection {

    default ValidatorBuilder doesContain(Collection<?> source, Object reference) {
        if (!CollectionValidator.doesContain(source, reference)) {
            ValidatorBuilder.invalidate();
            ValidatorBuilder.recordFailedTest("doesContain");
        }
        return ValidatorBuilder.getInstance();
    }

    default ValidatorBuilder doesContainAll(Collection<?> source, Collection<?> reference) {
        if (!CollectionValidator.doesContainAll(source, reference)) {
            ValidatorBuilder.invalidate();
            ValidatorBuilder.recordFailedTest("doesContain");
        }
        return ValidatorBuilder.getInstance();
    }

}
