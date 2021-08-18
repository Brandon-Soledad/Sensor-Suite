// Jonathan Lee
// TCSS 360 A
// Project 2, Group 7

package model;

import java.text.DecimalFormat;

/**
 * Represents the extra variable display options for the console receiver. This includes
 * converters for Fahrenheit and Celsius, and calculators for dew point and wind chill.
 * 
 * @author Jonathan Lee
 * @version 22 July 2020
 *
 */
public class ExtendedOptions {

	private static DecimalFormat df = new DecimalFormat("#.##");
	
	/**
	 * A converter for Celsius to Fahrenheit.
	 * 
	 * @param theCelsius is the temperature in Celsius.
	 * @return the temperature in Fahrenheit.
	 */
	public int celsiusToFahrenheit(double theCelsius) {
		return (int) (theCelsius * 1.8 + 32);
	}
	
	/**
	 * A converter for Fahrenheit to Celsius.
	 * 
	 * @param theFahrenheit is the temperature in Fahrenheit.
	 * @return the temperature in Celsius.
	 */
	public int fahrenheitToCelsius(double theFahrenheit) {
		return (int) ((theFahrenheit - 32) * .5556);
	}
	
	/**
	 * Used to calculate the dew point. This uses a simple approximation of
	 * the dew point for our purposes.
	 * 
	 * @param theTemp is a temperature sensor.
	 * @param theHumid is a humidity sensor.
	 * @return the dew point.
	 */
	public double getDewPoint(TemperatureSensor theTemp,
							HumiditySensor theHumid) {
		int temp = theTemp.getSensorReading();
		int humid = theHumid.getSensorReading();
		double a = (100 - humid) / 5.0;		
		// return temp - a;
		return Double.parseDouble(df.format(temp - a));

	}
	
	/**
	 * Used to calculate the wind chill.
	 * 
	 * @param theTemp is a temperature sensor.
	 * @param theAnem is an anemometer.
	 * @return the wind chill.
	 */
	public double getWindChill(TemperatureSensor theTemp,
								Anemometer theAnem) {
		String speedStr = theAnem.getCurrentWindSpeed();
		String str2 = speedStr.substring(0, speedStr.length() - 8);
		int speed = Integer.parseInt(str2);
		int temp = theTemp.getSensorReading();
		double cTemp = fahrenheitToCelsius(temp);
		double windSpeed = speed * 0.44704; // MPH to M/S
		double a = 0.6215 * cTemp;
		double b = 35.75 * Math.pow(windSpeed, 0.16);
		double c = 0.4275 * cTemp * Math.pow(windSpeed, 0.16);
		double sum = 35.74 + a - b + c;
		// return sum;
		return Double.parseDouble(df.format(sum));
	}
	
}
