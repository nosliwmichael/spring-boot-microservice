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

	static boolean isEqualToObject(Object source, Object reference) {
		if (source instanceof String && reference instanceof String) {
			return isEqualToString((String)source, (String)reference);
		} else if (isNull(source)) {
			return null == reference;
		} else {
			return source.equals(reference);
		}
	}

	static boolean isEqualToString(String source, String reference) {
		if (isNull(source) || source.isEmpty()) {
			return (null == reference || reference.isEmpty());
		} else {
			return source.equals(reference);
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
