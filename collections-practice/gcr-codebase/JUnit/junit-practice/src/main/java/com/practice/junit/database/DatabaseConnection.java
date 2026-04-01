package com.practice.junit.database;

public class DatabaseConnection {

	private boolean connected=false;
	
	public void connect() {
		
		System.out.println("database connected");
		connected=true;
	}
	
	public void disconnect() {
		System.out.println("database disconnected");
		connected=false;
	}
	
	public boolean isConnected() {
		return connected;
	}
	

}