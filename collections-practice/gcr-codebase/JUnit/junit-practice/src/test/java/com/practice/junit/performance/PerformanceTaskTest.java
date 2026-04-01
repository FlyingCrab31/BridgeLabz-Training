package com.practice.junit.performance;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class PerformanceTaskTest {

    PerformanceTask task = new PerformanceTask();

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS) 
    void testLongRunningTaskTimeout() {       
        task.longRunningTask();
    }
    
    

    @Test
    void testLongRunningTaskNormal() {
        String result = task.longRunningTask();
        assertEquals("Task Completed", result);
    }
}
