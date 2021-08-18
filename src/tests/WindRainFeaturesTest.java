// // Jonathan Lee, Brandon Soledad
// // TCSS 360 A
// // Project 2, Group 7

// package tests;

// import static org.junit.jupiter.api.Assertions.*;


// import model.*;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// /**
//  * A testing class used to test the wind and rain features of the console receiver.
//  * 
//  * @author Jonathan Lee
//  * @version 18 July 2020
//  */
// public class WindRainFeaturesTest {
	
// 	/**
// 	 * Represents an anemometer used for testing.
// 	 */
// 	private Anemometer myAnem;
	
// 	/**
// 	 * Represents a rain collector sensor used for testing.
// 	 */
// 	private RainCollectorSensor myRC;
	
// 	/**
// 	 * Represents the wind and rain features of the console receiver used
// 	 * for testing.
// 	 */
// 	private WindRainFeatures myFeatures;

// 	/**
// 	 * Sets up the necessary components for testing.
// 	 */
// 	@BeforeEach
// 	public void setUp() {
// 		myFeatures = new WindRainFeatures();
// 		myAnem = new Anemometer();
// 		myRC = new RainCollectorSensor();
// 	}
	
// 	/**
// 	 * Used to test the getRain() method.
// 	 */
// 	@Test
// 	public void testGetRain() {
// 		final double limit = 65536.0;
// 		for (int i = 0; i < 100; i++) {
// 			assertTrue(myFeatures.getRain(myRC) < limit, "Outside click limit");
// 		}
// 	}
	
// 	/**
// 	 * Used to test the getRainRecord() method.
// 	 */
// 	@Test
// 	public void testGetRainRecord() {
// 		for (int i = 0; i < 24; i++) {
// 			myFeatures.getRain(myRC);
// 		}
// 		assertTrue(myFeatures.getRainRecord().size() == 24, "Overflow of record");
// 	}
	
// 	/**
// 	 * Used to test the getWindDirect() method.
// 	 */
// 	@Test
// 	public void testGetWindDirect() {
// 		final int directLimit = 361;
// 		for (int i = 0; i < 100; i++) {
// 			assertTrue(myFeatures.getWindDirect(myAnem) < directLimit, "Outside direction limit");
// 		}
// 	}
	
// 	/**
// 	 * Used to test the getWindSpeed() method.
// 	 */
// 	@Test
// 	public void testGetWindSpeed() {
// 		final int speedLimit = 200;
// 		for (int i = 0; i < 100; i++) {
// 			assertTrue(myFeatures.getWindSpeed(myAnem) < speedLimit, "Outside speed limit");
// 		}
// 	}

// }
