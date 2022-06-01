package com.ms.franksmotor.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UtilTest {

	private final String passwordError = "jc123456";
	private final String passwordSuccess = "#Jc123456";
	
	@Test
	void validPasswordTest() {
		assertEquals(false, Utils.validPassword(passwordError));
		assertEquals(true, Utils.validPassword(passwordSuccess));
	}
}
