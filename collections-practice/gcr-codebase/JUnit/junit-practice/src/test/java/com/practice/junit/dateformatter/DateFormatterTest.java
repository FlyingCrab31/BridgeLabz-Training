package com.practice.junit.dateformatter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateFormatterTest {
	
	DateFormatter formatter=new DateFormatter();
	
	@Test
	 void testValidDate() {
		assertEquals("31-01-2025", formatter.formatDate("2025-01-31"));
	}

	
	@Test 
	void testInvalidDate() {
		assertThrows(IllegalArgumentException.class, () -> {
            formatter.formatDate("31-01-2025");
        });
	}
}
