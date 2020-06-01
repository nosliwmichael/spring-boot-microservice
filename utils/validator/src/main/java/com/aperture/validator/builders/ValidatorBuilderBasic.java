package com.aperture.validator.builders;

import com.aperture.validator.validators.BasicValidator;

import java.util.function.Predicate;

interface ValidatorBuilderBasic {

    default ValidatorBuilder isNull(Object source) {
        if (!BasicValidator.isNull(source)) {
            ValidatorBuilder.invalidate();
            ValidatorBuilder.recordFailedTest("isNull");
        }
        return ValidatorBuilder.getInstance();
    }

    default ValidatorBuilder isNotNull(Object source) {
        if (!BasicValidator.isNotNull(source)) {
            ValidatorBuilder.invalidate();
            ValidatorBuilder.recordFailedTest("isNotNull");
        }
        return ValidatorBuilder.getInstance();
    }

    default ValidatorBuilder isType(Object source, Class<?> type) {
        if (!BasicValidator.isType(source, type)) {
            ValidatorBuilder.invalidate();
            ValidatorBuilder.recordFailedTest("isType");
        }
        return ValidatorBuilder.getInstance();
    }

    default ValidatorBuilder isEqualToObject(Object source, Object reference) {
        if (!BasicValidator.isEqualToObject(source, reference)) {
            ValidatorBuilder.invalidate();
            ValidatorBuilder.recordFailedTest("isEqualToObject");
        }
        return ValidatorBuilder.getInstance();
    }

    default ValidatorBuilder isEqualToString(String source, String reference) {
        if (!BasicValidator.isEqualToString(source, reference)) {
            ValidatorBuilder.invalidate();
            ValidatorBuilder.recordFailedTest("isEqualToString");
        }
        return ValidatorBuilder.getInstance();
    }

    default ValidatorBuilder isTrue(Boolean source) {
        if (!BasicValidator.isTrue(source)) {
            ValidatorBuilder.invalidate();
            ValidatorBuilder.recordFailedTest("isTrue");
        }
        return ValidatorBuilder.getInstance();
    }

    default ValidatorBuilder isFalse(Boolean source) {
        if (!BasicValidator.isFalse(source)) {
            ValidatorBuilder.invalidate();
            ValidatorBuilder.recordFailedTest("isFalse");
        }
        return ValidatorBuilder.getInstance();
    }

    default ValidatorBuilder isStringLength(String source, Integer length) {
        if (!BasicValidator.isStringLength(source, length)) {
            ValidatorBuilder.invalidate();
            ValidatorBuilder.recordFailedTest("isStringLength");
        }
        return ValidatorBuilder.getInstance();
    }

    default ValidatorBuilder isStringLessThan(String source, Integer length) {
        if (!BasicValidator.isStringLessThan(source, length)) {
            ValidatorBuilder.invalidate();
            ValidatorBuilder.recordFailedTest("isStringLessThan");
        }
        return ValidatorBuilder.getInstance();
    }

    default ValidatorBuilder isStringLongerThan(String source, Integer length) {
        if (!BasicValidator.isStringLongerThan(source, length)) {
            ValidatorBuilder.invalidate();
            ValidatorBuilder.recordFailedTest("isStringLongerThan");
        }
        return ValidatorBuilder.getInstance();
    }

    default <T> ValidatorBuilder test(T value, Predicate<T> predicate) {
        if (!BasicValidator.test(value, predicate)) {
            ValidatorBuilder.invalidate();
            ValidatorBuilder.recordFailedTest("test");
        }
        return ValidatorBuilder.getInstance();
    }

}
