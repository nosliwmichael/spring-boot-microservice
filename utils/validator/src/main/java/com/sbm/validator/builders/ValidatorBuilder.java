package com.sbm.validator.builders;

import java.util.ArrayList;
import java.util.List;

public class ValidatorBuilder implements ValidatorBuilderBasic, ValidatorBuilderNumber, ValidatorBuilderCollection,
		ValidatorBuilderPattern {

	private boolean valid;
	private final List<String> testsFailed;
	private static ValidatorBuilder INSTANCE;

	private ValidatorBuilder() {
		valid = true;
		testsFailed = new ArrayList<>();
	}

	public static ValidatorBuilder create() {
		INSTANCE = new ValidatorBuilder();
		return INSTANCE;
	}

	public static ValidatorBuilder getInstance() {
		return INSTANCE;
	}

	public static boolean isValid() {
		return INSTANCE.valid;
	}

	public static void invalidate() {
		INSTANCE.valid = false;
	}

	public static List<String> getTestsFailed() {
		return INSTANCE.testsFailed;
	}

	protected static void recordFailedTest(String test) {
		INSTANCE.testsFailed.add(test);
	}

}
