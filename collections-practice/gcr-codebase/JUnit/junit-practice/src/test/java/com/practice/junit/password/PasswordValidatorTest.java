package com.practice.junit.password;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {
	
	PasswordValidator validator=new PasswordValidator();
	
	@Test
	
	void testValidPasswords() {
		assertTrue(validator.isValid("Password1"));
        assertTrue(validator.isValid("SecureA9"));
        assertTrue(validator.isValid("JavaTest8"));
	}
	
	
	@Test
	
	void testShortPassword() {
		assertFalse(validator.isValid("Pass1"));
	}
	
	@Test
	 void testNoUpperCase() {
		 assertFalse(validator.isValid("password1"));
	}
	
	@Test
	void testNoDigit() {
		assertFalse(validator.isValid("Password"));
	}
	
	@Test
	void testNullPassword() {
		assertFalse(validator.isValid(null));
	}

}
