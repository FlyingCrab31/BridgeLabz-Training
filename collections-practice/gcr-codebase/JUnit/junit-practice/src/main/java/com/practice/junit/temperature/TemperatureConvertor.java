package com.practice.junit.temperature;

public class TemperatureConvertor {
	
	public double celciusToFahrenheit(double celcius) {
		return (celcius*9/5)+32;
	}
	
	public double fahrenheitToCelcius(double farh) {
		return (farh-32)*5/9;
	}

}
