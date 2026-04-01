package com.practice.junit.userregistration;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class UserRegistrationTest {

    UserRegistration registration = new UserRegistration();

    @Test

    void testValidRegistration() {
        assertTrue(registration.registerUser(
                "rishabh",
                "rishh@gmail.com",
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
