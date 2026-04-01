package com.practice.junit.performance;

public class PerformanceTask {
	
	public String longRunningTask(){
		try {
			Thread.sleep(3000);
			
			
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		return "Task Completed";
	}

}
