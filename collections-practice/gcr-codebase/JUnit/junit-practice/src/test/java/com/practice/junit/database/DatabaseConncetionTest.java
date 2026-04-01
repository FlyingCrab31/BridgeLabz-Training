package com.practice.junit.database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConncetionTest {

    DatabaseConnection db;

    @BeforeEach
    void setUp() {
    	
        db = new DatabaseConnection();
        db.connect(); 
    }

    @AfterEach
    void tearDown() {
    	
        db.disconnect();
    }

    @Test
    void testConnectionEstablished() {
      
        assertTrue(db.isConnected(), "Database should be connected before test");
    }

    @Test
    void testConnectionClosedAfterTest() {
    	
        db.disconnect();
        assertFalse(db.isConnected(), "Database should be disconnected after test");
    }
}

