package com.practice.junit.temperature;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TemperatureConvertorTest {
	
	TemperatureConvertor converter=new TemperatureConvertor();
	
	@Test
	
	void testCelciusToFahrenheit() {
		assertEquals(32,converter.celciusToFahrenheit(0));
		assertEquals(212,converter.celciusToFahrenheit(100));
	}
	
@Test
	
	void testFarhenheitToCelcius() {
		assertEquals(0,converter.fahrenheitToCelcius(32));
		assertEquals(100,converter.fahrenheitToCelcius(212));
	}
	
	

}
