// // Jonathan Lee
// // TCSS 360 A
// // Project 2, Group 7

// package tests;

// import static org.junit.jupiter.api.Assertions.*;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import model.*;

// /**
//  * A testing class used to test the extended options of the console receiver.
//  * 
//  * @author Jonathan
//  * @version 22 July 2020
//  */
// public class ExtendedOptionsTest {
	
// 	/**
// 	 * Represents an anemometer for testing.
// 	 */
// 	private Anemometer myAnem;
	
// 	/**
// 	 * Represents a humidity sensor for testing.
// 	 */
// 	private HumiditySensor myHumid;
	
// 	/**
// 	 * Represents a temperature sensor for testing.
// 	 */
// 	private TemperatureSensor myTemp;
	
// 	/**
// 	 * Represents the extended console receiver options for testing.
// 	 */
// 	private ExtendedOptions myOptions;

// 	/**
// 	 * Sets up the necessary components for testing.
// 	 */
// 	@BeforeEach
// 	public void setUp() {
// 		myAnem = new Anemometer();
// 		myHumid = new HumiditySensor();
// 		myTemp = new TemperatureSensor();
// 		myOptions = new ExtendedOptions();
// 	}
	
// 	/**
// 	 * Used to test the Celsius to Fahrenheit converter.
// 	 */
// 	@Test
// 	public void testCelsiusToFahrenheit() {
// 		double fahrenheit = myOptions.celsiusToFahrenheit(25);
// 		assertEquals(fahrenheit, 77.0, "Unequal conversion");
// 	}
	
// 	/**
// 	 * Used to test the Fahrenheit to Celsius converter.
// 	 */
// 	@Test
// 	public void testFahrenheitToCelsius() {
// 		double celsius = myOptions.fahrenheitToCelsius(65);
// 		assertEquals(celsius, 18.334799999999998, "Unequal conversion");
// 	}

// 	/**
// 	 * Used to test the calculations for dew point.
// 	 */
// 	@Test
// 	public void testGetDewPoint() {
// 		myHumid.recalibrateData();
// 		myTemp.recalibrateData();
// 		for (int i = 0; i < 100; i++) {
// 			double dewPoint = myOptions.getDewPoint(myTemp, myHumid);
// 			assertTrue(dewPoint > -150 && dewPoint < 200, "Out of bounds");
// 			myHumid.recalibrateData();
// 			myTemp.recalibrateData();
// 		}
// 	}
	
// 	/**
// 	 * Used to test the calculations for wind chill.
// 	 */
// 	@Test
// 	public void testGetWindChill() {
// 		myTemp.recalibrateData();
// 		for (int i = 0; i < 100; i++) {
// 			double windChill = myOptions.getWindChill(myTemp, myAnem);
// 			assertTrue(windChill > -200 && windChill < 200, "Out of Bounds");
// 			myTemp.recalibrateData();
// 			myAnem.recalibrateData();
// 		}
// 	}

// }
