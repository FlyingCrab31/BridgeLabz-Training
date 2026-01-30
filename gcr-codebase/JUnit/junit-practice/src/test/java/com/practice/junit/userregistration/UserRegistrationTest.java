package com.practice.junit.userregistration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {
	
	UserRegistration registration=new UserRegistration();
	
	@Test
	
	void testValidRegistration() {
		  assertTrue(registration.registerUser(
	                "riddhi",
	                "riddhi@gmail.com",
	                "secret123"
	        ));
	}
	
	
	@Test
	
	void testInvalidEmail() {
		  assertThrows(IllegalArgumentException.class, () -> {
	            registration.registerUser("user", "gmail.com", "secret123");
	        });
	}
	
	@Test
	
	void testInvalidPassword() {
		 assertThrows(IllegalArgumentException.class, () -> {
	            registration.registerUser("user", "user@gmail.com", "123");
	        });
	}

}
