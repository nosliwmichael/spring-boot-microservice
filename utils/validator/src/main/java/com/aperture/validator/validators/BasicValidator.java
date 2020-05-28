package com.aperture.validator.validators;

import java.util.function.Predicate;

public interface BasicValidator {
	
	static boolean isNull(Object source) {
		return source == null;
	}
	
	static boolean isNotNull(Object source) {
		return source != null;
	}

	static boolean isType(Object source, Class<?> type) {
		return source.getClass() == type;
	}
	
	static boolean isEqualTo(Object source, Object reference) {
		if (isNotNull(source) && isNotNull(reference)) {
			return source.equals(reference);
		} else {
			return false;
		}
	}
	
	static boolean isTrue(Boolean source) {
		if (isNotNull(source)) {
			return (source);
		} else {
			return false;
		}
	}
	
	static boolean isFalse(Boolean source) {
		if (isNotNull(source)) {
			return (!source);
		} else {
			return false;
		}
	}
	
	static boolean isStringLength(String source, Integer length) {
		if (isNotNull(source) && isNotNull(length)) {
			return source.length() == length;
		} else {
			return false;
		}
	}
	
	static boolean isStringLessThan(String source, Integer length) {
		if (isNotNull(source) && isNotNull(length)) {
			return source.length() < length;
		} else {
			return false;
		}
	}
	
	static boolean isStringLongerThan(String source, Integer length) {
		if (isNotNull(source) && isNotNull(length)) {
			return source.length() > length;
		} else {
			return false;
		}
	}

	static <T> boolean test(T value, Predicate<? super T> predicate) {
		return predicate.test(value);
	}

}
