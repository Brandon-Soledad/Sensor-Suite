// Jonathan Lee
// TCSS 360 A
// Project 2, Group 7

// package tests;

// import static org.junit.jupiter.api.Assertions.*;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import model.*;

// /**
//  * Testing class used to test the barometer for the console receiver.
//  * 
//  * @author Jonathan Lee
//  * @version 25 July 2020
//  *
//  */
// public class BarometerFeaturesTest {

// 	/**
// 	 * Represents an anemometer for testing.
// 	 */
// 	private Anemometer myAnem;
	
// 	/**
// 	 * Represents a set of wind and rain features for testing.
// 	 */
// 	private WindRainFeatures myWindRain;
	
// 	/**
// 	 * Represents a barometer for testing.
// 	 */
// 	private BarometerFeatures myBarometer;
		
// 	/**
// 	 * Used to set up the necessary components for testing.
// 	 */
// 	@BeforeEach
// 	public void setUp() {
// 		myAnem = new Anemometer();
// 		myWindRain = new WindRainFeatures();
// 		myBarometer = new BarometerFeatures();
// 	}

// 	/**
// 	 * Used to test the calculateWindPressure() method for the barometer.
// 	 */
// 	@Test
// 	public void testCalculateWindPressure() {
// 		final double max = 0.52;
// 		double pressure = myBarometer.calculateWindPressure(myWindRain, myAnem);
// 		for (int i = 0; i < 100; i++) {
// 			assertTrue(pressure < max, "Out of bounds");
// 			myAnem.recalibrateData();
// 		}
// 	}
	
// 	/**
// 	 * Used to test the direction() method for the barometer.
// 	 */
// 	@Test
// 	public void testDirection() {
// 		boolean rise = myBarometer.direction() == Direction.RISING;
// 		boolean low = myBarometer.direction() == Direction.DECREASING;
// 		boolean med = myBarometer.direction() == Direction.STEADY;
// 		for (int i = 0; i < 100; i++) {
// 			assertTrue(rise || low || med, "Invalid Direction");
// 			myAnem.recalibrateData();
// 			myBarometer.calculateWindPressure(myWindRain, myAnem);
// 		}
// 	}

// }
