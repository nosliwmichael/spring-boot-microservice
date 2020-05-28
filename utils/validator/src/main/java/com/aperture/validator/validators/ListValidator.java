package com.aperture.validator.validators;

import java.util.Collection;

public interface ListValidator {

    static boolean doesContain(Collection<?> source, Object reference) {
        if (BasicValidator.isNotNull(source)) {
            return source.contains(reference);
        } else {
            return false;
        }
    }

    static boolean doesContainAll(Collection<?> source, Collection<?> reference) {
        if (BasicValidator.isNotNull(source) && BasicValidator.isNotNull(reference)) {
            return source.containsAll(reference);
        } else {
            return false;
        }
    }

}